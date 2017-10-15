package myproject.exceptionexample.service;

import com.google.common.base.Preconditions;
import lombok.Getter;
import myproject.exceptionexample.dao.IAdderssRepository;
import myproject.exceptionexample.dao.IUserRepository;
import myproject.exceptionexample.domain.Address;
import myproject.exceptionexample.domain.User;
import myproject.exceptionexample.exception.DefaultAddressNotDeleteException;
import myproject.exceptionexample.exception.NotFindeAddressException;
import myproject.exceptionexample.exception.NotFindeUserException;
import myproject.exceptionexample.exception.NotMatchUserAddressException;
import myproject.exceptionexample.validator.BeanValidators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.validation.Validator;
import java.util.List;



/**
 * Created by zhoulei on 2017/10/1.
 */
@Service
public class AdderssService implements IAdderssService{

    @Autowired
    private IUserRepository userDao;

    @Autowired
    private IAdderssRepository adderssDao;
    
    @Autowired
    private Validator validator;

    @Override
    public Address createAddress(Integer uid, Address address) {
        //用户id不为空，且必须存在
        Preconditions.checkNotNull(uid);
        User user = userDao.findOne(uid);
        if(null == user){
            throw new NotFindeUserException("用户不存在！");
        }
        //收货字段不能为 空
        BeanValidators.validateWithException(validator, address);

        //如果用户还没有收货地址，当此收货地址创建时为默认收货地址。
        if(ObjectUtils.isEmpty(user.getAddresses())){
            address.setIsDefault(true);
        }

        //业务代码
        address.setUser(user);
        Address result = adderssDao.save(address);
        return result;
    }

    @Override
    public void deleteAddress(Integer uid, Integer aid) {
        //用户id不能为空，且用户确实存在
        Preconditions.checkNotNull(uid);
        User user = userDao.findOne(uid);
        if(null == user){
            throw new NotFindeUserException("用户不存在！");
        }

        //收货地址不能为空，且此收货地址确实是存在的
        Preconditions.checkNotNull(aid);
        Address address = adderssDao.findOne(aid);
        if(null == address){
            throw  new NotFindeAddressException();
        }

        //判断此收货地址是否是用户的收货地址
        if(!address.getUser().equals(user)){
            throw new NotMatchUserAddressException();
        }

        if(address.getIsDefault()){
            throw new DefaultAddressNotDeleteException();
        }

        adderssDao.delete(aid);


    }

    @Override
    public List<Address> listAddress(Integer uid) {
        Preconditions.checkNotNull(uid);
        User user = userDao.findOne(uid);
        if(null == user){
            throw new NotFindeUserException("用户不存在！");
        }

        User result = userDao.findOne(uid);

        return result.getAddresses();
    }
}

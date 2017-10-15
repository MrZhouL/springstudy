package myproject.exceptionexample.service;

import myproject.exceptionexample.domain.Address;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhoulei on 2017/10/1.
 */
public interface IAdderssService {
    /**
     *
     * @param uid
     * @param address
     * @return
     */
    Address createAddress(Integer uid, Address address);

    /**
     *
     * @param uid
     * @param aid
     */
    void deleteAddress(Integer uid,Integer aid);

    /**
     *
     * @return
     */
    List<Address> listAddress(Integer uid);
}

package myproject.exceptionexample.api;

import myproject.exceptionexample.domain.Address;
import myproject.exceptionexample.exception.ApiException;
import myproject.exceptionexample.exception.ApiNotFindeUserException;
import myproject.exceptionexample.exception.ApiUserNotNullException;
import myproject.exceptionexample.exception.NotFindeUserException;
import myproject.exceptionexample.service.IAdderssService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by zhoulei on 2017/10/1.
 */
@RestController
public class MainController {

    @Autowired
    private IAdderssService adderssService;

    @RequestMapping(method = RequestMethod.POST)
    public AddressDTO add(@Valid  @RequestBody AddressDTO addressDTO){
        Address address = new Address();

        BeanUtils.copyProperties(addressDTO,address);

        Address result;
        try {
            result = adderssService.createAddress(addressDTO.getId(),address);
        }catch (NotFindeUserException e){
            throw new ApiNotFindeUserException("找不到该用户");
        }catch (NullPointerException e){
            throw new ApiUserNotNullException("用户还没登录");
        }
        catch (Exception e){
            throw new ApiException(e);
        }

        AddressDTO resultDTO = new AddressDTO();
        BeanUtils.copyProperties(result,resultDTO);
        resultDTO.setUser(result.getUser());

        return resultDTO;
    }
}

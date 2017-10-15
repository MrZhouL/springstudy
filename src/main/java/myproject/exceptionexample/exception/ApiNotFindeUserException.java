package myproject.exceptionexample.exception;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class ApiNotFindeUserException extends ApiException{

    public ApiNotFindeUserException(String message) {

        super(AddressErrorCode.NotFindUserErrorCode,message,null);
    }
}

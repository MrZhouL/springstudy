package myproject.exceptionexample.exception;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class ApiNotFindeAddressException extends ApiException {
    public ApiNotFindeAddressException(String message) {
        super(AddressErrorCode.NotFindAddressErrorCode,message,null);
    }

}

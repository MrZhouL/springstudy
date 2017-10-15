package myproject.exceptionexample.exception;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class ApiNotMatchUserAddressException extends ApiException {
    public ApiNotMatchUserAddressException(String message) {
        super(AddressErrorCode.NotMatchUserAddressErrorCode,message,null);

    }

}

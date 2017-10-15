package myproject.exceptionexample.exception;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class ApiUserNotNullException extends ApiException {
    public ApiUserNotNullException(String message) {
        super(AddressErrorCode.UserNotNullCode,message,null);
    }
}

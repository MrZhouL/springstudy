package myproject.exceptionexample.exception;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class ApiDefaultAddressNotDeleteException extends ApiException {
    public ApiDefaultAddressNotDeleteException(String message) {
        super(AddressErrorCode.DefaultAddressNotDeleteErrorCode,message,null);
    }
}

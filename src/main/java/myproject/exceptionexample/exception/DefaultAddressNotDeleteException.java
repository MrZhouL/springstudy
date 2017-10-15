package myproject.exceptionexample.exception;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class DefaultAddressNotDeleteException extends RuntimeException {
    public DefaultAddressNotDeleteException() {
        super("默认地址不能删除！！");
    }

    public DefaultAddressNotDeleteException(String message) {
        super(message);
    }
}

package myproject.exceptionexample.exception;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class NotMatchUserAddressException extends RuntimeException {
    public NotMatchUserAddressException(String message) {
        super(message);
    }

    public NotMatchUserAddressException() {
        super("没有匹配的用户地址！！");
    }
}

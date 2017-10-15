package myproject.exceptionexample.exception;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class NotFindeAddressException extends RuntimeException {
    public NotFindeAddressException(String message) {
        super(message);
    }

    public NotFindeAddressException() {
        super("没有找到此地址！");
    }
}

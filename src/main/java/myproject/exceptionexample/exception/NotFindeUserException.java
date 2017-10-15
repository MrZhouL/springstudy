package myproject.exceptionexample.exception;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class NotFindeUserException extends RuntimeException{
    public NotFindeUserException() {
        super("找不到此用户！！");
    }

    public NotFindeUserException(String message) {
        super(message);
    }
}

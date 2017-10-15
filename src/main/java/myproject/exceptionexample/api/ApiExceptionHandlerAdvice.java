package myproject.exceptionexample.api;

import lombok.Getter;
import lombok.Setter;
import myproject.exceptionexample.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhoulei on 2017/10/1.
 */
@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionHandlerAdvice {
    /**
     * Handle exceptions thrown by handlers.
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorDTO> exception(Exception exception, HttpServletResponse response) {
        ErrorDTO errorDTO = new ErrorDTO();
        if(exception instanceof ApiException){//api异常
            ApiException apiException = (ApiException)exception;
            errorDTO.setErrorCode(apiException.getErrorCode());
        }else{//未知异常
            errorDTO.setErrorCode(0L);
        }
        errorDTO.setTip(exception.getMessage());
        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(errorDTO, HttpStatus.valueOf(response.getStatus()));
        return responseEntity;
    }

    @Setter
    @Getter
    class ErrorDTO{
        private Long errorCode;
        private String tip;
    }
}

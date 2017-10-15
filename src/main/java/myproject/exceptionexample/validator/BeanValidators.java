package myproject.exceptionexample.validator;

import myproject.exceptionexample.domain.Address;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by zhoulei on 2017/10/1.
 */
public class BeanValidators {

    public static void validateWithException(Validator validator, Address address) {
        Set<ConstraintViolation<Object>> set = validator.validate(address,Validator.class);

        if (!set.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            for (ConstraintViolation vionlationMessages: set) {
                sb.append(vionlationMessages.getMessage());
            }
            throw new RuntimeException(sb.toString());
        }

    }
}

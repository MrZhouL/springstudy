package myproject.springstudy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by zhoulei on 2017/9/26.
 */
@RestController
public class SampleConteroller {

    @RequestMapping("/")
    String home(){
        return "Greetings from Spring Boot!";
    }
}

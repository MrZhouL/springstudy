package myexceptionexample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhoulei on 2017/9/30.
 */
@RestController
public class MainController {
    @RequestMapping("/")
    public String home(){
        return "你好";
    }

}

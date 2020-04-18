package lift.majiang.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/3/21 16:17
 * @Version 1.0
 **/
@Controller
public class HelloController {
    @GetMapping("/index")
    public String index(){

        return "index";
    }

}

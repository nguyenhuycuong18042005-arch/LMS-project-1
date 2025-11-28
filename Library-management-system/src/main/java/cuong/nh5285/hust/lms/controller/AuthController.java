package cuong.nh5285.hust.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // trả về home.html sau login thành công
    }
}

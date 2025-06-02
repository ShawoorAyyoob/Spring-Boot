package in.shawoor.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
    @GetMapping("/greets")
    private String greet(){
        return "Hello Spring Security From S&S";
    }
}

package version.controller;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author version
 * @version 1.0
 * @date 2020/4/4 18:26
 */
@RestController
@RequestMapping("/wen")
public class UserController {
    @GetMapping("/login1")
    public String index(){
        return "hello";
    }
}

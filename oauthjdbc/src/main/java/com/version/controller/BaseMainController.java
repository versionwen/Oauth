package com.version.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author version
 * @version 1.0
 * @date 2020/4/11 18:05
 */
@Controller
public class BaseMainController {
    @GetMapping("/auth/login")
    public String loginPage(Model model){

        model.addAttribute("loginProcessUrl","/auth/authorize");

        return "base-login";
    }
}

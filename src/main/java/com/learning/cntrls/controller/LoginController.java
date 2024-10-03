package com.learning.cntrls.controller;

import com.learning.cntrls.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    private RegisterService registerService;
    @GetMapping
    public String loginPage(Model model) {
        model.addAttribute("email", "");
        model.addAttribute("password", "");
        return "login";
    }

//    @PostMapping
//    public String loginValidation(@RequestParam("email") String email, @RequestParam("password") String password) {
//        int status = registerService.validateLoginDetails(email, password);
//        return "";
//    }
}

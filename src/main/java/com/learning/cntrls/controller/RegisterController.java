package com.learning.cntrls.controller;

import com.learning.cntrls.dto.RegisterDTO;
import com.learning.cntrls.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/web")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        model.addAttribute("data", new RegisterDTO());
        return "registration";
    }
///web/register
    @PostMapping("/register")
    public String validateRegistration(@ModelAttribute("data") RegisterDTO newUser, @RequestParam(value="extraField", required = false) String extraField) {
        System.out.println("data reached to controller: " + newUser);
        System.out.println("Extra field: " + extraField);
        registerService.addUser(newUser);
        return "login";
    }

    @ResponseBody
    @GetMapping("/temp")
    public Map<String, String> temp() {
        Map<String, String> data = new HashMap<>();

        data.put("name", "tarun");
        data.put("email", "tarunswaroop199@gmail.com");

        return data;
    }
}

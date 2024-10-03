package com.learning.cntrls.controller;

import com.learning.cntrls.dto.RegisterDTO;
import com.learning.cntrls.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
/**
 * Controller
 * ResponseBody
 */
@RequestMapping("/users")
public class UsersDataController {
    @Autowired
    private RegisterService registerService;

    @GetMapping("/{id}")
    public RegisterDTO getUser(@PathVariable("id") int id) {
        Optional<RegisterDTO> data = registerService.findById(id);
        System.out.println(data.get());
        if(data.isPresent()) return data.get();

        return null;
    }
}

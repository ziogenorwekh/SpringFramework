package com.example.springframwork.controller;


import com.example.springframwork.dto.User;
import com.example.springframwork.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Slf4j
@Controller
//@Component
public class GenericUserController extends GenericController<User, Integer, UserService> {
    @RequestMapping("/login")
    public String login(String userId, String password) {
        return "signUp";
    }
}

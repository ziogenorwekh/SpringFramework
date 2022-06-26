package com.example.springframwork;


import com.example.springframwork.dao.UserDao;
import com.example.springframwork.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

//@WebAppConfiguration
@SpringJUnitConfig(SpringConfig.class)
public class UserControllerTest {


    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    private MockMvc mockMvc;


}

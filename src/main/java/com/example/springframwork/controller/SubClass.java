package com.example.springframwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubClass extends SuperClass {

//    SuperClass 에서 RequestMapping 으로 상속 받아서 /super/sub 으로 들어갈 수 있다.
    @RequestMapping("/sub")
    public String hellow() {
        return "HighToSub";
    }
}

package com.java.csht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserInfoController {
    @RequestMapping("/userinfo")
    public ModelAndView UserInfo(){
        ModelAndView modelAndView = new ModelAndView("/userInfo");
        return modelAndView;
    }
}

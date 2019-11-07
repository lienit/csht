package com.java.csht.controller.BackManage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SortManageController {
    @RequestMapping("/sortManage")
    public ModelAndView SortManage(){
        ModelAndView modelAndView = new ModelAndView("backManage/sortManage");
        return modelAndView;
    }
}

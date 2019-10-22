package com.java.csht.controller;

import com.java.csht.model.User;
import com.java.csht.service.UserServier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @Autowired
    UserServier userServier;


    @RequestMapping("home")
    public ModelAndView Home(HttpServletRequest request){
        ModelAndView home = new ModelAndView("home");
        return home;
    }
    @RequestMapping("/login")
    public  ModelAndView login(){
        ModelAndView login = new ModelAndView("login");
        return login;
    }
    @PostMapping("/isLogin")
    public String isLogin(String username, String psw , HttpServletRequest request, RedirectAttributes  model){
        User user = new User();
        user.setUsername(username);
        user.setPsw(psw);
        boolean resultStr = userServier.UserLogin(user, request);
//        System.out.println(user1);
//        System.o.println(userService.LoginUser(admin, psw, request));

        if (resultStr){
            return "redirect:/home";
        }else {
            model.addFlashAttribute("msg", "登录失败！用户名或密码错误，请重试！");
            return "redirect:/login";
        }
    }



}

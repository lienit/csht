package com.java.csht.controller;

import com.java.csht.model.User;
import com.java.csht.service.UserServier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserInfoController {

    @Autowired
    private UserServier userServier;

    @RequestMapping("/userinfo")
    public ModelAndView UserInfo(){
        ModelAndView modelAndView = new ModelAndView("/userInfo");

        Integer count = 0;

//        根据username查找用户信息
        User user = new User();
        user.setUsername("李无心");
        User byUserName = userServier.findByUserName(user);
//截取邮箱,隐藏邮箱
        if (!byUserName.getMailbox().equals("")){
            String mailbox = byUserName.getMailbox();
            count++;
            String[] split = mailbox.split("@");
            Integer length = split[0].length()-3;
            String mailbox1 = split[0].substring(0,3);
            String mailbox2 = split[0].substring(length);
            byUserName.setMailbox(mailbox1+"*******"+mailbox2+"@"+split[1]);
        }

//        截取手机号，隐藏手机号
        if (!byUserName.getMobile().equals("")){
            String mobile = byUserName.getMobile();
            count++;
            Integer mobilelen = mobile.length()-3;
            String mobile1 = mobile.substring(0, 3);
            String mobile2 = mobile.substring(mobilelen);
            byUserName.setMobile(mobile1+"*******"+mobile2);

        }

        if (!byUserName.getPsw().equals("")){
            count++;
        }

        modelAndView.addObject("user", byUserName);
        modelAndView.addObject("count", count);

        return modelAndView;
    }

    @RequestMapping("/bindmobile")
    public ModelAndView BindMobile(String userId){
        ModelAndView modelAndView = new ModelAndView("/userInfo/bindmobile");
        User user = userServier.findById(userId);
        String mobile = user.getMobile();
        Boolean state = null;
        if (mobile.equals("")){
            state = false;
        }else {
            state = true;
        }
        System.out.println(state);
        modelAndView.addObject("state", state);
        return modelAndView;
    }
    @PostMapping("/bindnewmobile")
    @ResponseBody
    public String  BindNewMobile(String mobile, String psw){
        Boolean updataMobile = userServier.UpdateMobileByPsw(mobile, psw);
        if (updataMobile){
            return "success";
        }
        return "error";
    }
}

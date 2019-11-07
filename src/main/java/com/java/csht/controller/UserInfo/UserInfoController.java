package com.java.csht.controller.UserInfo;

import com.java.csht.model.User;
import com.java.csht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserInfoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userinfo")
    public ModelAndView UserInfo(){
        ModelAndView modelAndView = new ModelAndView("userInfo");

        Integer count = 0;

//        根据username查找用户信息

        User byUserName = userService.findByUserName("李无心");
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
//修改绑定手机
    @RequestMapping("/bindmobile")
    public ModelAndView BindMobile(String userId){
        ModelAndView modelAndView = new ModelAndView("userInfo/bindMobile");
        User user = userService.findById(userId);
        String mobile = user.getMobile();
        Integer id = user.getId();
        Boolean state = null;
        if (mobile.equals("")){
            state = false;
        }else {
            state = true;
        }


        System.out.println();
        modelAndView.addObject("state", state);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    @PostMapping("/bindnewmobile")
    @ResponseBody
    public String  BindNewMobile(String mobile, String psw,Integer userId){
        Boolean updataMobile = userService.UpdateMobileByPsw(mobile, psw, userId);
        if (updataMobile){
            return "success";
        }
        return "error";
    }

    @PostMapping("/editbindmobileiolp")
    @ResponseBody
    public String EditBindMobile(String mobile,String verify,Integer userId){
        return "success";
    }
//修改登录密码
    @RequestMapping("/editpsw")
    public ModelAndView editPsw(String userId){
        ModelAndView modelAndView = new ModelAndView("userInfo/editPsw");
        User user = userService.findById(userId);
        String mailbox = user.getMailbox();
        String mobile = user.getMobile();
        //截取邮箱,隐藏邮箱
        if (!mailbox.equals("")){

            String[] split = mailbox.split("@");
            Integer length = split[0].length()-3;
            String mailbox1 = split[0].substring(0,3);
            String mailbox2 = split[0].substring(length);
            user.setMailbox(mailbox1+"*******"+mailbox2+"@"+split[1]);
        }

//        截取手机号，隐藏手机号
        if (!mobile.equals("")){
            Integer mobilelen = mobile.length()-3;
            String mobile1 = mobile.substring(0, 3);
            String mobile2 = mobile.substring(mobilelen);
            user.setMobile(mobile1+"*******"+mobile2);

        }
        modelAndView.addObject("user", user);

        return modelAndView;
    }
    @PostMapping("/pswverify")
    @ResponseBody
    public String PswVerify(String userId, String editMode){
        System.out.println(userId);

        return "error";
    }

    @PostMapping("/pswedit")
    @ResponseBody
    public String PswEdit(){
        return "error";
    }

//    修改绑定邮箱
    @RequestMapping("/editmailbox")
    public ModelAndView EditMailbox(String userId){
        ModelAndView modelAndView = new ModelAndView("userInfo/editMailbox");
        User user = userService.findById(userId);
        String mailbox = user.getMailbox();
        String mobile = user.getMobile();
        //截取邮箱,隐藏邮箱
        if (!mailbox.equals("")){

            String[] split = mailbox.split("@");
            Integer length = split[0].length()-3;
            String mailbox1 = split[0].substring(0,3);
            String mailbox2 = split[0].substring(length);
            user.setMailbox(mailbox1+"*******"+mailbox2+"@"+split[1]);
        }

//        截取手机号，隐藏手机号
        if (!mobile.equals("")){
            Integer mobilelen = mobile.length()-3;
            String mobile1 = mobile.substring(0, 3);
            String mobile2 = mobile.substring(mobilelen);
            user.setMobile(mobile1+"*******"+mobile2);

        }

        modelAndView.addObject("user", user);
        return modelAndView;
    }
}

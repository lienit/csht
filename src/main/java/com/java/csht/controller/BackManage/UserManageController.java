package com.java.csht.controller.BackManage;

import com.java.csht.model.User;
import com.java.csht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserManageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/usermanage")
    public ModelAndView UserManage(){
        List<User> userList = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("backManage/userManage");
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @PostMapping("/adduser")
    @ResponseBody
    public String AddUser(User user){
        System.out.println(user.getUsername());
        User byUserName = userService.findByUserName(user.getUsername());
        if (byUserName==null){
            Boolean aBoolean = userService.insertUser(user);
            if (aBoolean){
                return "success";
            }
        }else {
            return "error";
        }
        return "";
    }

    @PostMapping("/deleuser")
    @ResponseBody
    public String DeleUser(String opt){
        String[] split = opt.split(",");
        for (String id :split){
            userService.deleteUser(id);
        }
        return "success";
    }

    @PostMapping("/resetpsw")
    @ResponseBody
    public String ResetPsw(String opt){
        String[] split = opt.split(",");
        for (String id :split){
            userService.UpdatePswById(id, "123456");
        }
        return "success";
    }

    @PostMapping("/updaterole")
    @ResponseBody
    public String UpdateRole(String id, String isadmin){
        String[] idArr = id.split(",");
        String[] isAminArr = isadmin.split(",");
        List<Boolean> isAdminList = new ArrayList<Boolean>();
        for (String admin : isAminArr){
            Boolean isAdmin = false;
            if (admin.equals("管理员")){
                isAdmin = true;
            }
            isAdminList.add(isAdmin);
        }
        for (int i=0 ; i < isAminArr.length ; i++){
            userService.UpdateIsAdminById(idArr[i],isAdminList.get(i));
        }
        return "success";
    }

    @PostMapping("/findByUserNameIsAdmin")
    @ResponseBody
    public List<User> findByUserNameIsAdmin(User user){
        System.out.println(user.getAdmin());
        List<User> byUserNameIsAdmin = userService.findByUserNameIsAdmin(user);
        return byUserNameIsAdmin;
    }

}

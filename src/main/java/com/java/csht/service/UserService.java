package com.java.csht.service;

import com.java.csht.mapper.UserMapper;
import com.java.csht.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> findByUserNameIsAdmin(User user){
        List<User> byUserNameIsAdmin = userMapper.findByUserNameIsAdmin(user);
        return byUserNameIsAdmin;
    }

    public Boolean UserLogin(User user, HttpServletRequest request){
        List<User> users = userMapper.LoginUser(user);
        String username = "";
        for (User user1 : users){
            username = user1.getUsername();
        }
        Integer size = users.size();
        boolean resultStr= size.equals(0)?false:true;
        if (resultStr){
            request.getServletContext().setAttribute("username", username);
        }
        return resultStr;
    }

    public List<User> findAll(){
        List<User> all = userMapper.findAll();
        return all;
    }

    public User findByUserName(String username){
        User byUserName = userMapper.findByUserName(username);
        return byUserName;
    }

    public User findById(String id){
        User byId = userMapper.findById(id);
        return byId;
    }

    public List<User> fingByMobile(String mobile, Integer id){
        List<User> byMobile = userMapper.findByMobile(mobile, id);
        return byMobile;
    }

    public Boolean UpdateMobileByPsw(String mobile, String psw,Integer id){
        boolean b = userMapper.updatetMobileBypPsw(mobile, psw, id);
        return b;
    }

    public Boolean UpdateByUserName(User user){
        boolean b = userMapper.updatetByUserName(user);
        return b;
    }

    public Boolean UpdatePswById(String id, String psw){
        boolean b = userMapper.updatePswById(id, psw);
        return b;
    }

    public Boolean UpdateIsAdminById(String id,Boolean isAdmin){
        boolean b = userMapper.updateIsAdminById(id, isAdmin);
        return b;
    }

    public Boolean insertUser(User user){
        Boolean aBoolean = userMapper.insertUser(user);
        return aBoolean;
    }

    public Boolean deleteUser(String id){
        Boolean aBoolean = userMapper.deleteUser(id);
        return aBoolean;
    }

}

package com.java.csht.service;

import com.java.csht.mapper.UserMapper;
import com.java.csht.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServier {
    @Autowired
    public UserMapper userMapper;

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
}

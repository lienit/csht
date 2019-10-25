package com.java.csht.mapper;

import com.java.csht.model.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface UserMapper {

    @Select("select * from user where username = #{username} and psw = #{psw}")
    public List<User> LoginUser(User user);

    @Select("select * from user where username = #{username}")
    public User findByUserName(User user);

    @Select("select * from user where id = #{id}")
    public User findById(String id);

    @Update("update user set mobile=#{mobile} where psw=#{psw}")
    public boolean updatetMobileBypPsw(String mobile, String psw);
}
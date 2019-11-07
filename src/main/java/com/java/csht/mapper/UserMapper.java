package com.java.csht.mapper;

import com.java.csht.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface UserMapper {
    public List<User> findByUserNameIsAdmin(User user);

    @Select("select * from user where username = #{username} and psw = #{psw}")
    public List<User> LoginUser(User user);

    @Select("select * from user where username = #{username}")
    public User findByUserName(String username);

    @Select("select * from user order by isAdmin desc")
    public List<User> findAll();

    @Select("select * from user where id = #{id}")
    public User findById(String id);

    @Select("select * from user where mobile = #{mobile} id = #{id}")
    public List<User> findByMobile(String mobile, Integer id);

    @Update("update user set mobile=#{mobile} where psw=#{psw} and id = #{id}")
    public boolean updatetMobileBypPsw(String mobile, String psw, Integer id);

    @Update("update user set photo=#{photo},mobile=#{mobile},sex=#{sex},address=#{address},photo=#{photo},realName=#{realname},birthday=#{birthday},mailbox=#{mailbox} where  userName = #{username}")
    public boolean updatetByUserName(User user);

    @Update("update user set psw=#{psw} where id = #{id}")
    public boolean updatePswById(String id,String psw);

    @Update("update user set isAdmin=#{isAdmin} where id = #{id}")
    public boolean updateIsAdminById(String id,Boolean isAdmin);

    @Insert("insert into user(username,mobile,isAdmin) values(#{username},#{mobile},#{isAdmin})")
    public Boolean insertUser(User user);

    @Delete("delete from user where  id = #{id}")
    public Boolean deleteUser(String id);


}
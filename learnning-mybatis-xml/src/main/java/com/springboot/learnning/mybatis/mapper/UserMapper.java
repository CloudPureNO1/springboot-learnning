package com.springboot.learnning.mybatis.mapper;

import com.springboot.learnning.mybatis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/25.
 */
public interface UserMapper {

    int insert(User user);
    int delete(Long id);
    int update(@Param("userId") Long id, @Param("userName") String name, @Param("userPasswd") String passwd, @Param("userAddr") String addr);
    List<User> select();
    List<User> selectByName(String name);

}

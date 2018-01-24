package com.springboot.learnning.mybatis2.mapper;

import com.springboot.learnning.mybatis2.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/23.
 */
public interface UserMapper {
    @Select("select * from t_user where user_id=#{id}")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPasswd",column = "user_passwd"),
            @Result(property = "userAddr",column = "user_addr")
    })
    User getUserById(@Param("id") Long id);

    @Select("select * from t_user")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPasswd",column = "user_passwd"),
            @Result(property = "userAddr",column = "user_addr")
    })
    List<User> getAll();

    @Insert("insert into t_user (user_id,user_name,user_passwd,user_addr) values(#{userId},#{userName},#{userPasswd},#{userAddr})")
    int insert(User user);

    @Insert("insert into t_user (user_id,user_name,user_passwd,user_addr) values(#{userId},#{userName},#{userPasswd},#{userAddr})")
    int insertUser(@Param("userId") Long userId,@Param("userName") String name,@Param("userPasswd")String userPasswd,@Param("userAddr") String userAddr);
}

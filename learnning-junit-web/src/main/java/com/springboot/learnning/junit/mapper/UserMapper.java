package com.springboot.learnning.junit.mapper;

import com.springboot.learnning.junit.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2018/1/26.
 */
public interface UserMapper {
    @Select("<script>"+
            "select * from t_user where user_id in"+
            "<foreach item='userId' index='index' collection='list' open='(' separator=',' close=')'>" +
            "#{userId}" +
            "</foreach>"+
            "</script>")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPasswd", column = "user_passwd"),
            @Result(property = "userAddr", column = "user_addr")
    })
    List<User> getUserByList(@Param("list") List<Long>list );


    @Select("<script>" +
            "select * from t_user where user_id in " +
            "<foreach collection='array' item='userId' open='(' separator=',' close=')'>" +
            "#{userId}" +
            "</foreach>" +
            "</script>")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPasswd",column = "user_passwd"),
            @Result(property = "userAddr" ,column = "user_addr")
    })
    List<User> getUserByArray(@Param("array") Long [] array);

    @Select("<script>" +
            "select * from t_user where user_name=#{map.userName} and user_id in " +
            "<foreach collection='map.ids' item='userId' open='(' separator=',' close=')'>" +
            "#{userId}" +
            "</foreach>" +
            "</script>")
    @Results({
            @Result(property = "userId" ,column ="user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPasswd",column = "user_passwd"),
            @Result(property = "userAddr",column = "user_Addr")
    })
    List<User> getUserByMap(@Param("map") Map<String,Object> map);

}

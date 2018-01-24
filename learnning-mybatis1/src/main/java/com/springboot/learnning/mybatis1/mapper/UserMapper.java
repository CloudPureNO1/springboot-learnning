package com.springboot.learnning.mybatis1.mapper;

import com.springboot.learnning.mybatis1.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/22.
 */
public interface UserMapper {
    @Insert("insert into t_user(user_id,user_name,user_passwd,user_addr) values(#{userId},#{userName},#{userPasswd},#{userAddr})")
    int insert(User user);

    @Select("select * from t_user where user_name=#{userName}")
    List<User> findByName(String userName);

    @Select("select * from t_user ")
    List<User> findAll();

    @Insert("insert into t_user(user_name,user_passwd,user_addr) values(#{userName},#{userPasswd},#{userAddr})")
    @Options(keyProperty ="userId",keyColumn = "user_id",useGeneratedKeys = true)
    int insertUser(User user);

    @Select("select * from t_user where user_id=#{userId}")
    User getUserById(Long id);
}

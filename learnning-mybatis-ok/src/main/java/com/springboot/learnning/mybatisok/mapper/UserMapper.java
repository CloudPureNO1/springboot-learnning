package com.springboot.learnning.mybatisok.mapper;

import com.springboot.learnning.mybatisok.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/16.
 */
public interface UserMapper {
    @Insert("insert into myuser(userid,username,passwd,addr) values (#{userid},#{username},#{passwd},#{addr})")
    int insert(User user);

    @Delete("delete from myuser where userid=#{userid}")
    int delete(Long userid);

    @Select("select * from myuser where userid=#{userid}")
    User findById(Long userId);

    @Select("select * from myuser")
    List<User> findAll();

    @Select("select * from myuser where username=#{username}")
    List<User>findByName(String username);
}

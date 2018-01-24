package com.springboot.learnning.mybatis1.mapper;

import com.springboot.learnning.mybatis1.model.MyUser;
import com.springboot.learnning.mybatis1.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/22.
 */
public interface MyUserMapper {
    @Select("select * from myuser")
    List<MyUser> getAll();

    @Insert("insert into myuser(userid,username,passwd,addr) values(#{userid},#{username},#{passwd},#{addr})")
     int insert(MyUser user) ;
}

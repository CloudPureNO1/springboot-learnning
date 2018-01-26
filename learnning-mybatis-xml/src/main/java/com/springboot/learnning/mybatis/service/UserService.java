package com.springboot.learnning.mybatis.service;

import com.springboot.learnning.mybatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/25.
 */
public interface UserService {
   int insert(User user);
    int delete(Long id);
    int update(Long id,String name,String passwd,String addr);
    List<User> select();
    List<User> selectByName(String name);
}

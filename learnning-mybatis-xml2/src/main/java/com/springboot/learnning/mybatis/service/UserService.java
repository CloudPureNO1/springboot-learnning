package com.springboot.learnning.mybatis.service;

import com.springboot.learnning.mybatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2018/1/25.
 */
public interface UserService {
    int insert(User user);
    int delete(@Param("userId") Long id);
    int update(User user);
    User getUserById(@Param("id") Long id);
    List<User> getAll();
    List<User> getByProperties(User user);


    List<User> selectByConditions(User user);
    int updateUser(User user);
    List<User>selectUserByList(List<Long> list);
    List<User>selectUserByArray(Long [] aIds);
    List<User>selectUserByMap(Map<String,?> map);
}

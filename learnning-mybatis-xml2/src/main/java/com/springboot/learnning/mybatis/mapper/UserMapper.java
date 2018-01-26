package com.springboot.learnning.mybatis.mapper;

import com.springboot.learnning.mybatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2018/1/25.
 */
public interface UserMapper {
    int insert(User user);
    int delete(@Param("userId") Long id);
    int update(User user);
    User selectById(@Param("id") Long id);
    List<User> selectAll();
    List<User> selectByProperties(User user);



    List<User> selectByConditions(User user);
    int updateUser(User user);
    List<User>selectUserByList(List<Long> list);
    List<User>selectUserByArray(Long [] aIds);
    List<User>selectUserByMap(Map<String,?>map);
}

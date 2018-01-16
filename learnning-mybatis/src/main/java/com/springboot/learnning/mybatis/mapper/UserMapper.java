package com.springboot.learnning.mybatis.mapper;

import com.springboot.learnning.mybatis.model.User;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByUserName(String userName);
    List<User> findListUser();
}
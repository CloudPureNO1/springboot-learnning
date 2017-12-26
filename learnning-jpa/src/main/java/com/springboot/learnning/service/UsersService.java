package com.springboot.learnning.service;

import com.springboot.learnning.dao.mapping.Users;

import java.util.List;

/**
 * Created by CloudPure on 2017/12/25.
 */
public interface UsersService {
    public int saveUsers(Users users);
    public List<Users> getUsers();
}

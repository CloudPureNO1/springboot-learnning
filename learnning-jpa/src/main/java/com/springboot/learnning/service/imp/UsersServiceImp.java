package com.springboot.learnning.service.imp;

import com.springboot.learnning.dao.UsersDao;
import com.springboot.learnning.dao.mapping.Users;
import com.springboot.learnning.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CloudPure on 2017/12/25.
 */
@Service
public class UsersServiceImp implements UsersService {
    @Autowired
    private UsersDao usersDao;
    @Override
    public int saveUsers(Users users) {
        return usersDao.saveUsers(users);
    }

    @Override
    public List<Users> getUsers() {
        return usersDao.getUsers();
    }
}

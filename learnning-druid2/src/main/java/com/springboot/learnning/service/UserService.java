package com.springboot.learnning.service;

import com.springboot.learnning.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by CloudPure on 2017/12/27.
 */
public interface UserService {
    List<User> getAll();
}

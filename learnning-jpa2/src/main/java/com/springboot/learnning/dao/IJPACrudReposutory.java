package com.springboot.learnning.dao;

import com.springboot.learnning.dao.mapping.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by CloudPure on 2017/12/26.
 */
public interface IJPACrudReposutory extends CrudRepository<User,Integer> {
}

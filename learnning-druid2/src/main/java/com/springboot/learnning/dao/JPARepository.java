package com.springboot.learnning.dao;

import com.springboot.learnning.dao.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by CloudPure on 2017/12/27.
 */
public interface JPARepository extends CrudRepository<User, Long> {
}

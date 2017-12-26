package com.springboot.learnning.dao;

import com.springboot.learnning.dao.mapping.Users;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2017/12/25.
 */
public interface UsersDao {
    public int saveUsers(Users user);

    public int deleteUsers(Users user);

    public int deleteUsers(Integer userId);

    public int updateUsers(Users user);

    public int updateUsers(Integer userid);

    public List getUsers();

    public List<Users> getUsers(Users user);

    public Users getUsers(Integer userId);

    public List<Users>getUsersByProperty(Users user);

    public List<Users>getUserByProperty(String property);

    public Page getUserPage(Map<String,Object> params);
}

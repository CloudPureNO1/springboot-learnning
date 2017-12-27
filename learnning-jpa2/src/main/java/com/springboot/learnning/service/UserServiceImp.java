package com.springboot.learnning.service;

import com.springboot.learnning.dao.IJPACrudReposutory;
import com.springboot.learnning.dao.mapping.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CloudPure on 2017/12/27.
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private IJPACrudReposutory reposutory;

    @Override
    public User save(User u){
      u=  reposutory.save(u);
      return u;
    }

    @Override
    public void delete(User u){
        reposutory.delete(u);
    }

    @Override
    public boolean update(User u){
       boolean b= reposutory.equals(u);
       return b;
    }

    @Override
    public User getUser(Integer id){
       User u=reposutory.findOne(id);
        return u;
    }

    @Override
    public List<User> findAll(){
        List<User>list=new ArrayList<User>();
        Iterable<User> it= reposutory.findAll();
        java.util.Iterator<User>itUtil=it.iterator();
        while(itUtil.hasNext()){
            list.add(itUtil.next());
        }
        return list;
    }

    @Override
    public List<User> findAll1(){
        List<User>list=new ArrayList<User>();
        Iterable<User> it= reposutory.findAll();
        for(User u:it){
            list.add(u);
        }
        return list;
    }
}

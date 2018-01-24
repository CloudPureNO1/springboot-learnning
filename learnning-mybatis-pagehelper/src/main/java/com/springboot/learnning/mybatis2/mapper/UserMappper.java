package com.springboot.learnning.mybatis2.mapper;

import com.springboot.learnning.mybatis2.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by CloudPure on 2018/1/23.
 */
public interface UserMappper {
    @Insert("insert into t_user(user_id,user_name,user_passwd,user_addr) values(#{userId},#{userName},#{userPasswd},#{userAddr})")
    int insert(User user);
    @Delete("delete from t_user where user_id=#{userId}")
    int delete(Long userId);
    @Update("update t_user set user_name=#{userName}, user_passwd=#{userPasswd},user_addr=#{userAddr} where user_id=#{userId}")
    int update(User user);
    @Select("select * from t_user where user_id=#{userId}")
    User getUserById(Long userId);
    @Select("select * from t_user")
    List<User> getAll();


    /**
     * 如果值与数据库中的不对应，需要用@Param("")来绑定参数
     * 否则报异常：nested exception is org.apache.ibatis.binding.BindingException:
     * Parameter 'name' not found. Available parameters are [0, 1, param1, param2]
     *  出现这个异常的原因是因为你在使用@insert的使用，没有进行相应的字段对应关系。
     * @param id
     * @param name
     * @param passwd
     * @return
     */
    @Update("update t_user set user_name=#{name},user_passwd=#{passwd} where user_id=#{id}")
    int updateUser(@Param("id") Long id, @Param("name") String name, @Param("passwd") String passwd);
}

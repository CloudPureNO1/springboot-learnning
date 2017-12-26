package com.springboot.learnning.dao.imp;

import com.springboot.learnning.dao.UsersDao;
import com.springboot.learnning.dao.mapping.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by CloudPure on 2017/12/25.
 */
@Repository  //用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean
public class UsersDaoImp implements UsersDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int saveUsers(Users user) {
        int i=-1;
        String sql="insert into my_users(user_id,user_name,user_passwd) values(?,?,?)";
        i=jdbcTemplate.update(sql, new PreparedStatementSetter() {//防止sql注入
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,user.getUserId());
                preparedStatement.setString(2,user.getUserName());
                preparedStatement.setString(3,user.getUserPasswd());
            }
        });
        return i;
    }

    @Override
    public int deleteUsers(Users user) {
        return 0;
    }

    @Override
    public int deleteUsers(Integer userId) {
        return 0;
    }

    @Override
    public int updateUsers(Users user) {
        return 0;
    }

    @Override
    public int updateUsers(Integer userid) {
        return 0;
    }

    @Override
    public List<Users> getUsers() {
        String sql="select * from my_users";

        List<Users> list=jdbcTemplate.query(sql, new ResultSetExtractor<List<Users>>() {
            @Override
            public List<Users> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Users>list=new ArrayList<Users>();
                Users u=null;
                while(resultSet.next()){
                    u=new Users();
                    u.setUserid(resultSet.getInt(1));
                    u.setUserName(resultSet.getString(2));
                    u.setUserpasswd(resultSet.getString(3));
                    list.add(u);
                }

                return list;
            }
        });

        return list;
    }

    @Override
    public List<Users> getUsers(Users user) {
        return null;
    }

    @Override
    public Users getUsers(Integer userId) {
        return null;
    }

    @Override
    public List<Users> getUsersByProperty(Users user) {
        return null;
    }

    @Override
    public List<Users> getUserByProperty(String property) {
        return null;
    }

    @Override
    public Page getUserPage(Map<String, Object> params) {
        return null;
    }


}

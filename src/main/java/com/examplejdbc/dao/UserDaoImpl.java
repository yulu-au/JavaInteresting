package com.examplejdbc.dao;

import com.examplejdbc.pojo.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private MyJdbcTemplate template;

    public UserDaoImpl(MyJdbcTemplate template){
        this.template = template;
    }

    @Override
    public void addUser(User user) throws SQLException {

    }

    @Override
    public void deleteUser(User user) throws SQLException {

    }

    @Override
    public void updateUser(User user) throws SQLException {

    }

    @Override
    public User getUser(int userid) {
        String sql = "select * from user2 where id = ?";
        List resultUser = template.query(sql, new Object[] {userid}, new RowMap() {
            @Override
            public Object rowMap(ResultSet rs) throws SQLException {
                User row = new User();
                row.setName(rs.getString("name"));
                row.setAge(rs.getInt("age"));
                row.setBirthday(rs.getDate("birthday"));
                return row;
            }
        });

        return (User)resultUser.get(0);
    }

    @Override
    public User findUser() {
        return null;
    }
}

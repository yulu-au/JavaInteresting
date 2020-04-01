package com.examplejdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private MyJdbcTemplate template;

    public UserDaoImpl(MyJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void addUser(User user) {
        String sql = "insert into user2(name, age, birthday) values(?, ?, ?)";
        Object[] args = {user.getName(), user.getAge(), user.getBirthday()};
        template.update(sql, args);
    }

    @Override
    public void deleteUser(int userid) {
        String sql = "delete from user2 where id = ?";
        Object[] args = {userid};
        template.update(sql, args);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user2 set name = ? , age = ? , birthday = ? where id = ?";
        Object[] args = {user.getName(), user.getAge(), user.getBirthday(), user.getId()};
        template.update(sql, args);
    }

    @Override
    public User getUser(int userid) {
        String sql = "select * from user2 where id = ?";
        List<Object> resultUser = template.query(sql, new Object[]{userid}, new RowMap() {
            @Override
            public Object rowMap(ResultSet rs) throws SQLException {
                User row = new User();
                row.setName(rs.getString("name"));
                row.setAge(rs.getInt("age"));
                row.setBirthday(rs.getDate("birthday"));
                return row;
            }
        });

        return (User) resultUser.get(0);
    }


}

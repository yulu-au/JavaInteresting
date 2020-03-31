package com.examplejdbc.dao;

import com.examplejdbc.pojo.User;

import java.sql.SQLException;

public interface UserDao {
    public void addUser(User user) throws SQLException;
    public void deleteUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public User getUser(int userid);
    public User findUser();
}

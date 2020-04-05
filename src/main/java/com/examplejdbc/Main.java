package com.examplejdbc;


import java.sql.*;

import com.examplejdbc.dao.MyJdbcTemplate;
import com.examplejdbc.dao.UserDao;
import com.examplejdbc.dao.UserDaoImpl;
import com.examplejdbc.dao.User;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("xiaoha");
        user.setAge(3);
        user.setBirthday(new Date(1585716235000L));

        UserDao userDao = new UserDaoImpl(new MyJdbcTemplate());
        userDao.updateUser(user);
    }
}

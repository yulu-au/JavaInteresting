package com.examplejdbc;


import java.sql.*;

import com.examplejdbc.dao.MyJdbcTemplate;
import com.examplejdbc.dao.UserDao;
import com.examplejdbc.dao.UserDaoImpl;
import com.examplejdbc.jdbc.JdbcUtils;
import com.examplejdbc.pojo.User;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl(new MyJdbcTemplate());
        User user = userDao.getUser(2);
        System.out.println(user);
    }
}

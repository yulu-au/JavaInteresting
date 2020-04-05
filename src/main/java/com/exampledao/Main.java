package com.exampledao;

import java.sql.Date;

import com.exampledao.dao.UserDao;
import com.exampledao.pojo.User;
import com.exampledao.util.DaoFactory;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("jj");
        user.setAge(3);
        user.setBirthday(new Date(1585716235000L));

        UserDao userDao = DaoFactory.getInstance().getUserDao();
        userDao.updateUser(user);
    }
}

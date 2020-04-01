package com.examplejdbc.dao;

/*
定义了对user表进行数据访问的抽象
 */
public interface UserDao {
    public void addUser(User user);

    public void deleteUser(int userid);

    public void updateUser(User user);

    public User getUser(int userid);
}

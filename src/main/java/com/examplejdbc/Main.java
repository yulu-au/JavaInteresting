package com.examplejdbc;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //测试mysql连接
        String url = "jdbc:mysql://localhost:3306/test" +
                "?serverTimezone=Asia/Shanghai" +
                "&useSSL=false" +
                "&user=root" +
                "&password=mysql";
        //拿到连接对象
        Connection connection = DriverManager.getConnection(url);
        System.out.println(connection);
        connection.close();
    }
}

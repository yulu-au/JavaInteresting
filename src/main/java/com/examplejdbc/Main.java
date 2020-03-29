package com.examplejdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        //读入数据库配置
        Properties properties = new Properties();
        InputStream in = new FileInputStream(new File("E:/下载/JavaInteresting/src/main/resources/jdbc.properties"));
        properties.load(in);

        String url = properties.getProperty("jdbcUrl");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //拿到连接对象
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        connection.close();
    }
}

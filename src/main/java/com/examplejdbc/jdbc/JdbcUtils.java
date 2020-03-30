package com.examplejdbc.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static Properties ps = null;

    static{
        ps = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(new File("E:/下载/JavaInteresting/src/main/resources/jdbc.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ps.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ps.getProperty("jdbcUrl"),ps.getProperty("user"),ps.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static boolean free(){
        return false;
    }
}

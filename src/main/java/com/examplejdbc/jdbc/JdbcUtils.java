package com.examplejdbc.jdbc;

import java.io.*;
import java.sql.*;
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

    //try(resource)释放资源更加便捷
    public static void free(ResultSet rs, PreparedStatement ps, Connection conn){
        try{
            if(rs != null)
                rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(ps != null)
                    ps.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                    try {
                        if(conn != null)
                            conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}


package com.examplejdbc.dao;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*
抽取了jdbc的公共操作
 */
public class MyJdbcTemplate {
    private static Properties ps = null;

    static {
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

    public static Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ps.getProperty("jdbcUrl"), ps.getProperty("user"), ps.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void update(String sql, Object[] args) {
        try (Connection conn = getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for (int i = 1; (i - 1) < args.length; i++) {
                    ps.setObject(i, args[i - 1]);
                }
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object> query(String sql, Object[] args, RowMap rowMap) {
        List<Object> resultList = new ArrayList<>();
        try (Connection conn = getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for (int i = 1; (i - 1) < args.length; i++) {
                    ps.setObject(i, args[i - 1]);
                }

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Object obj = rowMap.rowMap(rs);
                        resultList.add(obj);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
}

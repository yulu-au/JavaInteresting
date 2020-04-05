package com.exampledao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

    // 初始化一个数据源
    private static MyDataSource dataSource = new MyDataSource();

    // 获取连接
    public static Connection getConnection() throws SQLException {
        // 从数据源获取Connection并返回
        return dataSource.getConnection();
    }

    // 获取数据源
    public static MyDataSource getDataSource() {
        return dataSource;
    }

    // 释放连接
    public static void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null)
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
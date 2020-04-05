package com.exampledao.dao;

import com.exampledao.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
抽取了jdbc的公共操作
 */
public class MyJdbcTemplate {

    public int update(String sql, Object[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 1; (i - 1) < args.length; i++) {
                ps.setObject(i, args[i - 1]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.free(null, ps, conn);
        }

    }

    public List<Object> query(String sql, Object[] args, RowMap rowMap) {
        List<Object> resultList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 1; (i - 1) < args.length; i++) {
                ps.setObject(i, args[i - 1]);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                Object obj = rowMap.rowMap(rs);
                resultList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }

        return resultList;
    }
}

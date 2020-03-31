package com.examplejdbc.dao;

import com.examplejdbc.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyJdbcTemplate {
    void update(String sql, Object[] args){
        try(Connection conn = JdbcUtils.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                for(int i =1; i<args.length; i++){
                    ps.setObject(i, args[i]);
                }
                ps.executeUpdate();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    List query(String sql, Object[] args, RowMap rowMap){
        List resultList = new ArrayList();
        try(Connection conn = JdbcUtils.getConnection()){
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                for(int i =1; (i-1)<args.length; i++){
                    ps.setObject(i, args[i-1]);
                }

                try(ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        Object obj = rowMap.rowMap(rs);
                        resultList.add(obj);
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return resultList;
    }
}

package com.examplejdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
MyJdbcTemplate->query方法参数需要传递一个映射的逻辑
 */
public interface RowMap {
    Object rowMap(ResultSet rs) throws SQLException;
}

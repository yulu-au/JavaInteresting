package com.examplejdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMap {
    Object rowMap(ResultSet rs) throws SQLException;
}

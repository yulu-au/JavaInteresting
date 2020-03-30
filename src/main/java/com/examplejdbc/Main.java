package com.examplejdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.examplejdbc.jdbc.JdbcUtils;

public class Main {
    public static void main(String[] args) throws Exception {

        //拿到连接对象
        Connection connection = JdbcUtils.getConnection();
        //创建sql模版
        String sql = "select * from user_ where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,2);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getObject(1)
                    +"\t"+resultSet.getObject(2)
                    +"\t"+resultSet.getObject(3)
                    +"\t"+resultSet.getObject(4));
        }
        connection.close();
    }
}

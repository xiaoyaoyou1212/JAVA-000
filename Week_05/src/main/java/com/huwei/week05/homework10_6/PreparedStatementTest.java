package com.huwei.week05.homework10_6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: 使用 PreparedStatement 操作
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 15:52
 * @FileName: PreparedStatementTest
 * Copyright (C), 2015-2020
 */
public class PreparedStatementTest {
    private static String sql;

    public static void main(String[] args) throws Exception {
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //查询
        sql = "SELECT * FROM tb_student WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, 2);
        query(preparedStatement, resultSet);
        //增加
        sql = "INSERT INTO tb_student VALUES(?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, null);
        preparedStatement.setObject(2, "逍遥游");
        System.out.println("插入执行结果:" + update(preparedStatement));
        //更新
        sql = "UPDATE tb_student SET name = ? WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, "胡伟");
        preparedStatement.setObject(2, 2);
        System.out.println("更新执行结果:" + update(preparedStatement));
        //删除
        sql = "DELETE FROM tb_student WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, 4);
        System.out.println("删除执行结果:" + update(preparedStatement));
        JdbcUtils.close(connection, preparedStatement, resultSet);
    }

    private static void query(PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("name"));
        }
    }

    private static int update(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeUpdate();
    }
}

package com.huwei.week05.homework10_6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Description: JDBC 原生操作
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 15:52
 * @FileName: JdbcTest
 * Copyright (C), 2015-2020
 */
public class JdbcTest {
    private static String sql;

    public static void main(String[] args) throws Exception {
        Connection connection = JdbcUtils.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        //查询
        sql = "SELECT * FROM tb_student";
        query(statement, sql, resultSet);
        //增加
        sql = "INSERT INTO tb_student VALUES(NULL, '逍遥游')";
        System.out.println("插入执行结果:" + update(statement, sql));
        //更新
        sql = "UPDATE tb_student SET name='胡伟' WHERE id = 1";
        System.out.println("更新执行结果:" + update(statement, sql));
        //删除
        sql = "DELETE FROM tb_student WHERE id = 1";
        System.out.println("删除执行结果:" + update(statement, sql));
        JdbcUtils.close(connection, statement, resultSet);
    }

    private static void query(Statement statement, String sql, ResultSet resultSet) throws SQLException {
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getObject("name"));
        }
    }

    private static int update(Statement statement, String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }
}

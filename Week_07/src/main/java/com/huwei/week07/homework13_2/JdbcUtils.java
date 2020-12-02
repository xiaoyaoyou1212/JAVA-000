package com.huwei.week07.homework13_2;

import java.sql.*;

/**
 * @Description: JDBC 连接管理
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/11/21 15:45
 * @FileName: JdbcUtils
 * Copyright (C), 2015-2020
 */
public class JdbcUtils {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/db_e_commerce_trade?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
    private static final String USER = "test";
    private static final String PASSWORD = "123456";

    static {
        try {
            Class.forName(DRIVER_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

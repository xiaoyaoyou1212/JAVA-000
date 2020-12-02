package com.huwei.week07.homework13_2;

import java.sql.*;

/**
 * @Description: 批量插入
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/1 17:52
 * @FileName: BatchInsertTask
 * Copyright (C), 2015-2020
 */
public class BatchInsertTask {

    private static final int COUNT = 1000000;

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("开始插入数据----batchInsert");
        int insertCount = batchInsert();
        long end = System.currentTimeMillis();
        System.out.println("结束插入数据----batchInsert");

        long startLarge = System.currentTimeMillis();
        System.out.println("开始插入数据----largeBatchInsert");
        int insertCountLarge = largeBatchInsert();
        long endLarge = System.currentTimeMillis();
        System.out.println("结束插入数据----largeBatchInsert");

        System.out.println("插入数量：" + insertCount + "，执行时间：" + (end - start) + "毫秒");
        System.out.println("插入数量：" + insertCountLarge + "，执行时间：" + (endLarge - startLarge) + "毫秒");
    }

    private static String getSql() {
        String sql = "INSERT INTO tb_order(" +
                "order_id," +
                "user_id," +
                "order_no," +
                "order_status," +
                "order_time," +
                "order_price," +
                "order_real_price," +
                "pay_time," +
                "pay_price," +
                "pay_type," +
                "pay_status," +
                "del_status," +
                "create_time," +
                "update_time" +
                ") VALUES (" +
                "NULL," +
                "1," +
                "?," +
                "3," +
                "now()," +
                "5," +
                "5," +
                "now()," +
                "5," +
                "1," +
                "2," +
                "0," +
                "now()," +
                "now())";
        return sql;
    }

    private static int batchInsert() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        connection.setAutoCommit(false);
        String sql = getSql();
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 1; i <= COUNT; i++) {
            String orderNo = "NO." + i;
            System.out.println("生成订单：" + orderNo);
            ps.setString(1, orderNo);
            ps.addBatch();
        }
        int[] ints = ps.executeBatch();
        connection.commit();
        JdbcUtils.close(connection, ps, null);
        return ints.length;
    }

    private static int largeBatchInsert() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        connection.setAutoCommit(false);
        String sql = getSql();
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 1; i <= COUNT; i++) {
            String orderNo = "NO." + i;
            System.out.println("生成订单：" + orderNo);
            ps.setString(1, orderNo);
            ps.addBatch();
        }
        long[] ints = ps.executeLargeBatch();
        connection.commit();
        JdbcUtils.close(connection, ps, null);
        return ints.length;
    }

}

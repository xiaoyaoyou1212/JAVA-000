package com.huwei.week07.homework14_2;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.function.Consumer;

/**
 * @Description: TODO
 * @Author: <a href="http://www.huwei.tech">dawi</a>
 * E-mail:xiaoyaoyou1212@foxmail.com
 * GitHub:https://github.com/xiaoyaoyou1212
 * @Date: 2020/12/2 17:08
 * @FileName: DbConfig
 * Copyright (C), 2015-2020
 */
@Configuration
public class DbConfig {

    @Bean(name = "dbRoute")
    public DataSource dbRoute() throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties pp = new Properties();
        pp.load(in);

        Map<Object, Object> targetDataSources = new HashMap<>(DbType.values().length);
        Arrays.stream(DbType.values()).forEach(dbType -> targetDataSources.put(dbType, getDataSource(pp, dbType)));

        DbRoute dbRoute = new DbRoute();
        dbRoute.setTargetDataSources(targetDataSources);
        return dbRoute;
    }

    private DataSource getDataSource(Properties pp, DbType dbType) {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();

        builder.driverClassName(pp.getProperty(String.format("spring.datasource%1$s.driver-class-name", dbType.getCode())));
        builder.url(pp.getProperty(String.format("spring.datasource%1$s.jdbc-url", dbType.getCode())));
        builder.username(pp.getProperty(String.format("spring.datasource%1$s.username", dbType.getCode())));
        builder.password(pp.getProperty(String.format("spring.datasource%1$s.password", dbType.getCode())));

        return builder.build();
    }
}

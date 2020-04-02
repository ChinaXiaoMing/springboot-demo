package com.opencode.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * @Description DOTO
 * @Author xiaoming
 * @Date 2020/4/2 19:46
 * @Version 1.0
 **/
@Configuration
@MapperScan(basePackages = "com.opencode.dao")
public class DruidConfig {

    @Bean
    public DruidDataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        druidDataSource.setMaxActive(20);
        druidDataSource.setMinIdle(1);
        druidDataSource.setInitialSize(1);
        druidDataSource.setFilters("wall");
        return druidDataSource;
    }

    @Bean
    public StatFilter statFilter() {
        StatFilter statFilter = new StatFilter();
        statFilter.setMergeSql(true);
        statFilter.setSlowSqlMillis(1000L);
        return statFilter;
    }

}

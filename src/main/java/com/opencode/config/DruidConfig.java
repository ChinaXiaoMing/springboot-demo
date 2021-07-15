package com.opencode.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.util.TimeZone;

/**
 * 德鲁伊的配置
 *
 * @author fu.yuanming
 * @date 2021-07-14
 */
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

    @Bean
    public JacksonProperties jacksonProperties() {
        JacksonProperties jacksonProperties = new JacksonProperties();
        jacksonProperties.setDateFormat("yyyy-MM-dd HH:mm:ss");
        jacksonProperties.setTimeZone(TimeZone.getTimeZone("GTM+8"));
        return jacksonProperties;
    }

}

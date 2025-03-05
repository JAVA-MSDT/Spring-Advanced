package com.customstarter.datasource.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(DataSource.class)
public class DataSourceCustomConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceCustomConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public DataSource getDataSource() {
        logger.info("========== Initializing DataSource from DataSourceCustomConfiguration Class ==========");
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}

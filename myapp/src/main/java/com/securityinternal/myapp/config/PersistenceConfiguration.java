package com.securityinternal.myapp.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource() {

        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5433/postgres");
        builder.password("mypassword");
        builder.username("postgres");
        System.out.println("Customer Data Source Loaded");
        return builder.build();
    }
}

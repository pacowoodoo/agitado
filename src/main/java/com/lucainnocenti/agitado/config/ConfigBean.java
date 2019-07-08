package com.lucainnocenti.agitado.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Data
@EnableAsync
@Configuration
public class ConfigBean {

    @Value("${spring.agidata.datasource.jdbc-url}")
    private String jdbcurl;

    @Value("${spring.agidata.datasource.driver-class-name}")
    private String driveClassName;

    @Value("${spring.agidata.datasource.username}")
    private String username;

    @Value("${spring.agidata.datasource.password}")
    private String password;

}


package com.lucainnocenti.agitado.datasource;

import com.lucainnocenti.agitado.config.ConfigBean;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManager",
        transactionManagerRef = "mysqlTransactionManager",
        basePackages = "com.lucainnocenti.agitado.datasource"
)
@RequiredArgsConstructor
public class Agidata {

	@Autowired
    private ConfigBean configBean;

    @Primary
    @Bean
    public DataSource customDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(configBean.getDriveClassName());
        dataSource.setUrl(configBean.getJdbcurl());
        dataSource.setUsername(configBean.getUsername());
        dataSource.setPassword(configBean.getPassword());

        return dataSource;

    }
}
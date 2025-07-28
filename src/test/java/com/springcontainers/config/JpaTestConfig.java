package com.springcontainers.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.testcontainers.containers.MySQLContainer;

@Profile("test")
@TestConfiguration
@EnableJpaRepositories(basePackages = "com.springcontainers.repository", entityManagerFactoryRef = "entityManager")
public class JpaTestConfig {

    @Bean
    public DataSource dataSource(MySQLContainer<?> mysqlContainer) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(mysqlContainer.getJdbcUrl());
        ds.setUsername(mysqlContainer.getUsername());
        ds.setPassword(mysqlContainer.getPassword());
        ds.setDriverClassName(mysqlContainer.getDriverClassName());
        ds.setMaximumPoolSize(Integer.valueOf(10));

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManager(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan("com.springcontainers.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        return entityManagerFactoryBean;
    }

    @Primary
    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManager) {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManager.getObject());
        return tm;
    }
}

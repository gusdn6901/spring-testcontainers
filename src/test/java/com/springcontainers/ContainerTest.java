package com.springcontainers;

import com.springcontainers.config.ContainerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest
@Import(ContainerConfig.class)
public class ContainerTest {

    @Autowired
    private MySQLContainer<?> mySQLContainer;

    @Test
    void contextLoads() {
        System.out.println("MySQL Container JDBC URL: " + mySQLContainer.getJdbcUrl());
        System.out.println("MySQL Container User Name: " + mySQLContainer.getUsername());
        System.out.println("MySQL Container Password: " + mySQLContainer.getPassword());
        System.out.println("MySQL Container Driver Class: " + mySQLContainer.getDriverClassName());
    }

}

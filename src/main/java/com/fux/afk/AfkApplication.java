package com.fux.afk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class AfkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfkApplication.class, args);
    }

}

package com.gpms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.gpms.dao.mapper")
public class GpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpmsApplication.class, args);
    }

}

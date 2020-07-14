package com.mc.springtrainnew;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mc.springtrainnew.*")
@SpringBootApplication
public class SpringtrainnewApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtrainnewApplication.class, args);
    }

}

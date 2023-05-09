package com.edpl.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CourseManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseManagerServiceApplication.class, args);
    }

}

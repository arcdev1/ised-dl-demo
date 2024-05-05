package com.ised;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ised.controller.ExcelController;


@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "com.ised.controller")
@Import({ ExcelController.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
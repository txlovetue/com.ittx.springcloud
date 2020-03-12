package com.ittx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 步骤：
 *  - 引入相对应的Maven坐标：spring-cloud-starter-eureka-server
 *  - 编写application.yml文件
 *  - 编写主线程类，使用@EnableEurekaServer开启对Eureka相关注解的支持
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka7001MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001MainApplication.class, args);
    }
}

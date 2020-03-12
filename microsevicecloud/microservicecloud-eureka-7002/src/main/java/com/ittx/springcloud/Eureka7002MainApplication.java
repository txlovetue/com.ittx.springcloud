package com.ittx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka7002MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7002MainApplication.class, args);
    }
}

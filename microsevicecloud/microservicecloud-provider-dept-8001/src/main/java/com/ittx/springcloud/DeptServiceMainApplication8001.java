package com.ittx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务会自动注册进Eureka注册中心中
@EnableDiscoveryClient//启动服务发现
public class DeptServiceMainApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptServiceMainApplication8001.class, args);
    }
}

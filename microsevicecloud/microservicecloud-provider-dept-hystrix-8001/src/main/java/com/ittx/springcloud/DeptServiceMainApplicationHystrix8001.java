package com.ittx.springcloud;

import com.ittx.springcloud.entities.Dept;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//本服务会自动注册进Eureka注册中心中
@EnableDiscoveryClient
@EnableCircuitBreaker//开启对熔断器的支持
public class DeptServiceMainApplicationHystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptServiceMainApplicationHystrix8001.class, args);
    }
}

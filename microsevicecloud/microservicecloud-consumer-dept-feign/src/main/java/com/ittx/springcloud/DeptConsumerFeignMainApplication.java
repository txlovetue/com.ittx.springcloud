package com.ittx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ittx.service.dept.feign"})
@ComponentScan({"com.ittx.springcloud","com.ittx.service.dept.hystrix"})
@EnableCircuitBreaker//只要在启动类以及controller类中使用@HystrixCommand注解就可以被dashboard监控(pom文件需要引入hystrix坐标)
public class DeptConsumerFeignMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeignMainApplication.class, args);
    }
}

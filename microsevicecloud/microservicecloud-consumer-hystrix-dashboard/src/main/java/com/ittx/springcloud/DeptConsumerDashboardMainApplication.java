package com.ittx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//注意：使用dashboard的服务必须引入actuator依赖
@EnableHystrixDashboard //开启对dashboard的支持
public class DeptConsumerDashboardMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashboardMainApplication.class, args);
    }
}

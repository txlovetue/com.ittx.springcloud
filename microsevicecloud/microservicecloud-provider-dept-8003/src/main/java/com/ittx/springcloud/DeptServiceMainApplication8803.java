package com.ittx.springcloud;

import com.ittx.springcloud.entities.Dept;
import com.ittx.springcloud.service.DeptService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.ittx.springcloud.dao")//这里配置了就可以省略dao类中指定@Mapper
public class DeptServiceMainApplication8803 {
    public static void main(String[] args) {
        SpringApplication.run(DeptServiceMainApplication8803.class, args);
    }
}

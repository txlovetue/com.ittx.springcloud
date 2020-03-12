package com.ittx.springcloud;

import com.ittx.myribbonrules.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
//@EnableDiscoveryClient //本服务会自动发现Eureka注册中心中的服务
@EnableEurekaClient
//@RibbonClient表示在该微服务启动的时候，针对MICROSERVICECLOUD-PROVIDER-DEPT这个服务加载自定义负载均衡策略
@RibbonClient(name = "MICROSERVICECLOUD-PROVIDER-DEPT", configuration = {MyselfRule.class})
public class DeptConsumerMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerMainApplication.class, args);
    }
}

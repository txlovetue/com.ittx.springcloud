package com.ittx.springcloud.cfgbean;

import com.ittx.myribbonrules.myselfrules.MyselfRule02;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 使用此类来代替spring配置Bean对象的xml文件
 * 复习：
 *      <bean id="userService" class="com.ittx.service.UserService"></bean>
 */
@Configuration
public class ConfigBean {
    /**
     * RestTemplate与JDBCTemplate、RedisTemplate都属于模板
     * RestTemplate提供了多种便捷访问远程http服务的方法。是一种简单便捷的访问restful服务模板类，是Spring提供用于访问Rest服务的客户端模板工具
     * @return
     */
    @Bean
    @LoadBalanced//Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡工具
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
    public IRule myRibbonRule(){
        //使用随机算法替代默认的轮询机制
        return new RandomRule();
//        return new MyselfRule02();//改成自定义规则  这里是错误的。因为自定义配置类不能放在@ComponentScan扫描的包下
    }
}

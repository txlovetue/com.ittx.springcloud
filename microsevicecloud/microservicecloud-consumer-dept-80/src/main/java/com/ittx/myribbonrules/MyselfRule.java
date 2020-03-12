package com.ittx.myribbonrules;

import com.ittx.myribbonrules.myselfrules.MyselfRule02;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
//        return new RandomRule();//Ribbon是默认，现在采用自定义
        return new MyselfRule02();//改成自定义
    }
}

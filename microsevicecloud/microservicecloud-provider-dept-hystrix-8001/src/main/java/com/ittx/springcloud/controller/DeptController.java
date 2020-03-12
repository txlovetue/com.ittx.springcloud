package com.ittx.springcloud.controller;

import com.ittx.springcloud.entities.Dept;
import com.ittx.springcloud.service.impl.DeptServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出异常信息后，会自动调用fallbackMethod指定的方法
    //这里的代码有很大的两个问题：1.每个方法都跟随一个fallbackMethod导致这个类方法膨胀；2.违背了Spring切面编程的思想，业务处理不纯粹了
    //在api项目中使用的feign使用了接口编程的方式，利用AOP思想将hystrix熔断机制提取出去统一到了接口级别
//    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = this.deptService.get(id);
        if (null == dept){
            throw new RuntimeException("该ID:" + id + "没有对应的数据");
        }
        return dept;
    }

    //在api项目中已经将熔断提出到了接口上，这里就不需要这段代码，使此业务类能够纯粹的处理业务
//    public Dept processHystrix_Get(@PathVariable("id") Long id){
//        return new Dept().setDeptno(id).setDname("该ID" + id + "没有对应的数据").setDb_source("no this DataBase in Mysql");
//    }
}

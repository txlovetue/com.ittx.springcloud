package com.ittx.springcloud.controller;

import com.ittx.service.dept.feign.DeptClientService;
import com.ittx.springcloud.entities.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DeptController_Consumer_Feign {
    @Autowired
    private DeptClientService service;

    //方便测试都使用的是HTTP的Get方法
    //注意：这里不能使用GetMapping，会报404错误的
//    @GetMapping("/consumer/dept/add")
    @RequestMapping(value = "/consumer/dept/add", method = RequestMethod.GET)
    public boolean add(Dept dept){
        return service.add(dept);
    }

//    @GetMapping("/consumer/dept/get/{id}")
    @HystrixCommand
    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> list(){
        return service.list();
    }

    //测试服务发现
//    @GetMapping("/dept/discovery")
//    public Object discovery(){
//        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
//    }
}

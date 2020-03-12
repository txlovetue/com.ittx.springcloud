package com.ittx.springcloud.controller;

import com.ittx.springcloud.entities.Dept;
import com.ittx.springcloud.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptServiceImpl deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

//    @GetMapping("/dept/get/{id}")
    //如果要视同feign的话都不能使用GetMapping
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    /**
     * 服务发现
     * @return
     */
    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        System.out.println("******" + services);

        //创建注册中心中与MICROSERVICECLOUD-PROVIDER-DEPT-8001名字一样的服务对象
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance:instances){
            System.out.println(instance.getHost() + "：" + instance.getServiceId() + "：" + instance.getUri());
        }
        return this.discoveryClient;
    }
}

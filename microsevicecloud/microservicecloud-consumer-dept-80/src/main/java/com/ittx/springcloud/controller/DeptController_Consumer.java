package com.ittx.springcloud.controller;

import com.ittx.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    //    private static final String REST_URL_PREFIX = "http://localhost:8001";
    //使用微服务的服务名访问服务
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-PROVIDER-DEPT";

    /**
     * （url,requestMap,ResponseBean.class）:三个参数分别表示：REST请求服务地址，请求参数，HTTP响应转换（被转换成的对象类型）
     */
    @Autowired
    private RestTemplate restTemplate;

//    @PostMapping("/consumer/dept/add")

    @GetMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    //测试服务发现
    @GetMapping("/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }

}

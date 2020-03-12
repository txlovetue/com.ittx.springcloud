package com.ittx.service.dept.feign;

import com.ittx.service.dept.hystrix.DeptClientServiceFallbackFactory;
import com.ittx.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//使用Feign的时候一定注意，必须使用@RequestMapping(value, method)的形式，否则报404
//value表示调用的服务名，与eureka中注册的服务名有关
//这里将hystrix服务提取到了接口层面
@FeignClient(value = "MICROSERVICECLOUD-PROVIDER-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
//@FeignClient(value = "MICROSERVICECLOUD-PROVIDER-DEPT")
public interface DeptClientService {

//    @GetMapping("/consumer/dept/add")这里写客户端的访问地址是错误的，因为我们是给服务端做熔断器，所以使用服务端的RequestMapping，
    //否则客户端所有请求都会执行服务降级，导致服务不可用
    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    public boolean add(Dept dept);

//    @GetMapping("/consumer/dept/get/{id}")
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);

    @SuppressWarnings("unchecked")
//    @GetMapping("/consumer/dept/list")
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list();
}

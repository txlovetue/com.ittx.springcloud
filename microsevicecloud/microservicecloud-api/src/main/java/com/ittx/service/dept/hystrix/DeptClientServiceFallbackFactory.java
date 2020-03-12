package com.ittx.service.dept.hystrix;

import com.ittx.service.dept.feign.DeptClientService;
import com.ittx.springcloud.entities.Dept;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component   //千万不要忘记加Component注解
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的数据，Consumer客户端提供的降级信息，此服务Provider已经停止" +
                        "关闭").setDb_source("no this DataBase in the Mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}

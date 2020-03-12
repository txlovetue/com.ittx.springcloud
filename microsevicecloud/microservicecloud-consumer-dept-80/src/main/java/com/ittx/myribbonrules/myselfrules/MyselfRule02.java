package com.ittx.myribbonrules.myselfrules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 需求分析：
 *  需求：采用轮询的方式访问微服务，每个微服务访问5次后再轮询到下一个服务
 *  分析：
 *      - 服务访问次数索引：超过5次后需要重置为0
 *      - 服务个数索引：超过服务提供的个数后需要重置为0
 *      - 当提供的服务不存在的时候使用Thread.yield()让出线程执行权
 */
public class MyselfRule02 extends AbstractLoadBalancerRule {
//    private static ThreadLocal<Integer> threadLocal;
    private int executeCount = 0;          //每个服务总共执行了多少次，超过5次重置为0
    private int serverIndex = 0;    //当前提供服务的服务器编号
//    private int serverCount = 0;    //获取的服务数量

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key){
        if (lb == null){
            return null;
        }
        //这里只是声明对象，并没有创建对象，所以不必将其声明到方法外（在方法内创建对象会造成每次调用都新创建对象，消耗资源）
        Server server = null;
        while(server == null){
            //如果线程受阻就返回null，相当于不执行
            if (Thread.interrupted()){
                return null;
            }
            //获取全部可用服务
            List<Server> upList = lb.getReachableServers();
            //获取注册了的全部服务（包括可能已经DOWN了的服务）
//            List<Server> countList = lb.getAllServers();
//            serverCount = countList.size();
            if (upList.size() == 0){
                return null;
            }
            if (executeCount < 2){
                executeCount++;
                server = (Server) upList.get(serverIndex);
                if (server == null){
                    Thread.yield();
                }else {
                    if (server.isAlive()){
                        return server;
                    }
                    server = null;
                    Thread.yield();
                }
            }else {
                executeCount = 0;
                serverIndex++;
                if (serverIndex >= upList.size()){
                    serverIndex = 0;
                }
                continue;
            }
            return server;
        }
        return null;
    }

    @Override
    public Server choose(Object o) {
        return this.choose(this.getLoadBalancer(), o);
    }
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}

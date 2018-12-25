package com.jianzhang.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;
    //获取 服务实例信息//与DiscoveryClient类似
    @Autowired
    private DiscoveryClient namingService;


    private final  String serviceName="service-provider";

    @GetMapping("/test/{name}")
    public String test(@PathVariable String name) throws  Exception{
        List<ServiceInstance> instanceList =namingService.getInstances(serviceName);
        instanceList.forEach(instance ->System.out.print("#"+instance.getServiceId()+"_"+instance.getHost()+":"+instance.getPort()));
        String url ="http://"+serviceName+"/echo/"+name;
        return restTemplate.getForObject(url, String.class);
    }
}

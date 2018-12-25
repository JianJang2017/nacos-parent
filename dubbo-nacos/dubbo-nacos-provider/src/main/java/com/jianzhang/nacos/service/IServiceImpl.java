package com.jianzhang.nacos.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jianzhang.nacos.IService;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "1.0.0")
public class IServiceImpl  implements IService{
    @Value("${demo.service.name}")
    private String serviceName;
    @Override
    public String sayHello(String name) {
        return "Hello Service "+name;
    }
}

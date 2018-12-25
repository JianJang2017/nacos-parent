package com.jianzhang.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class TestController {
    @Value("${service.api.name}")
    private String serviceApiName;
    @GetMapping("/get")
    public String get(String name){
       return serviceApiName +": "+name;
    }
}

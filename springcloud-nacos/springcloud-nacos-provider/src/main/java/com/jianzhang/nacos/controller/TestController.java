package com.jianzhang.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String  server;
    @GetMapping("/echo/{name}")
    public String echo(@PathVariable String name){

        return "Hello "+name +" from "+server;
    }
}

package com.jianzhang.nacos.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jianzhang.nacos.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consumer")
public class TestController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Reference(version = "1.0.0")
    private IService iService;
    @GetMapping("/test")
    public String test( String name){
        logger.info("iService:{}",iService);
        return iService.sayHello(name);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam String name){
      String ss ="你好%s，您的账号%s";
      logger.info("msg :{}",String.format(ss,new String []{"张先生","0001"}));
        return iService.sayHello(name);
    }
}

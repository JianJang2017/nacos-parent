package com.jianzhang.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudNacosConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudNacosConsumerApplication.class, args);
	}

}


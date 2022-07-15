package com.ydlclass.nacosprovider8000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //注册中心
public class NacosProvider8000Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider8000Application.class, args);
    }

}

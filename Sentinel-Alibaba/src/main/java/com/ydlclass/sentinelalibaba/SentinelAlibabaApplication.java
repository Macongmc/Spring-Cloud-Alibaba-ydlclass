package com.ydlclass.sentinelalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelAlibabaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelAlibabaApplication.class, args);
    }

}

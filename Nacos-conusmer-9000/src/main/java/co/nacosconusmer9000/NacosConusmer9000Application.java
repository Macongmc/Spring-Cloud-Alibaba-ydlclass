package co.nacosconusmer9000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConusmer9000Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosConusmer9000Application.class, args);
    }

}

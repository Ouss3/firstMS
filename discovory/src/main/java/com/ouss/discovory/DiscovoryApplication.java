package com.ouss.discovory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscovoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscovoryApplication.class, args);
    }

}

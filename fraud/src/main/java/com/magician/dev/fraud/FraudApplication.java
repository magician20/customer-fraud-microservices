package com.magician.dev.fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient; //enabled by default

@SpringBootApplication
@EnableJpaAuditing
public class FraudApplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class, args);

    }
}

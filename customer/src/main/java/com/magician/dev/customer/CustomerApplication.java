package com.magician.dev.customer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient; //enabled by default

@SpringBootApplication(
        // inject amqp package
        scanBasePackages = {
                "com.magician.dev.customer",
                "com.magician.dev.amqp",
        }
)
//@EnableDiscoveryClient
@EnableFeignClients(
    basePackages = "com.magician.dev.clients"
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);

    }

}

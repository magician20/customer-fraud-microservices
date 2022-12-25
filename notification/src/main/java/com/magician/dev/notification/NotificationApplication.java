package com.magician.dev.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient; //enabled by default

@SpringBootApplication(
        // inject amqp package
        scanBasePackages = {
                "com.magician.dev.notification",
                "com.magician.dev.amqp",
        }
)
@EnableJpaAuditing
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);

    }

//    for testing producer
//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig notificationConfig
//    ){
//        return args->{
//          producer.publish(
//                  new Person("Ahmed",18),
//                  notificationConfig.getInternalExchange(),
//                  notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
//    record Person(String name,int age){}
}

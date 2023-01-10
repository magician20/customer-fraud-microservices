package com.magician.dev.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient; //enabled by default

@SpringBootApplication(
        scanBasePackages = {
                "com.magician.dev.notification",
            // inject amqp package 
                "com.magician.dev.amqp",
        }
)
@EnableJpaAuditing
@PropertySources({
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
})
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

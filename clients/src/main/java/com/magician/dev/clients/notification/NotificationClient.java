package com.magician.dev.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//this is no more use cause we use rabbitmq
@FeignClient(
        name = "notification",
        url="${clients.notification.url}"
)
public interface NotificationClient {
    
    @PostMapping(path = "api/v1/notification")
    void sendNotification(@RequestBody NotificationRequest notificationRequest);

}

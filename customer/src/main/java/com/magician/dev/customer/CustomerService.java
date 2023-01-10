package com.magician.dev.customer;

import com.magician.dev.amqp.RabbitMQMessageProducer;
import com.magician.dev.clients.fraud.FraudCheckResponse;
import com.magician.dev.clients.fraud.FraudClient;
//import com.magician.dev.clients.notification.NotificationClient;
import com.magician.dev.clients.notification.NotificationRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class CustomerService {
        private final CustomerRepository customerRepository;
        private final FraudClient fraudClient;
        // private final NotificationClient notificationClient;
        private final RabbitMQMessageProducer rabbitMQMessageProducer;

        public void registerCustomer(CustomerRegistrationRequest request) {
                Customer customer = Customer.builder()
                                .firstName(request.firstName())
                                .lastName(request.lastName())
                                .email(request.email())
                                .build();
                // todo: check if email valid
                // todo: check if email not taken
                customerRepository.saveAndFlush(customer);
                // todo: check if fraudster
                FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

                if (fraudCheckResponse.isFraudster()) {
                        throw new IllegalStateException("fraudster");
                }
                // todo: send notification
                NotificationRequest notificationRequest = new NotificationRequest(
                                customer.getId(),
                                customer.getEmail(),
                                String.format("Hi %s, welcome to Land of Magic ...", customer.getFirstName()));
                // not need anymore cause we're going to use RabbitMQ
                // notificationClient.sendNotification(
                // notificationRequest
                // );
                // todo: make it async i.e add to queue
                rabbitMQMessageProducer.publish(
                                notificationRequest,
                                "internal.exchange",
                                "internal.notification.routing-key");

        }
}

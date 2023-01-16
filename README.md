# customer services

- Microservices Architecture Proposal:
![MQServices](https://user-images.githubusercontent.com/11742710/209483141-06d54d9f-ab68-4c3d-a522-ed2dc93f881e.png)

- Microservices Architecture Proposal with K8s:
![K8s arch](https://user-images.githubusercontent.com/11742710/211629049-b5addd66-094f-4ba2-8290-2d011cb78ca7.png)


implemented by using below:

- Spring Boot 3.0.1
- Spring MVC, Spring WebFlux, Validation
- Spring Data JPA
- postgresql
- lombok
- actuator
- micrometer 1.10.2
- Spring Cloud 2022.0.0
- Routing (openfeign)
- Distributed Tracing (Brave bridge + micrometer & Zipkin)
- Service Discovery (Eureka -> K8s )
- Load Balancing (Spring Cloud Gateway -> K8s)
- AMQP (RabbitMQ)
- Container (Docker -> K8s containerd)
- K8s Deployment to Linode cloud

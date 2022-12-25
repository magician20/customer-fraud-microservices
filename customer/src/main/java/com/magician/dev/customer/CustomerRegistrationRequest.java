package com.magician.dev.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {

}

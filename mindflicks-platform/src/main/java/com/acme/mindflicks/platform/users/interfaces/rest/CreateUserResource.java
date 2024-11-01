package com.acme.mindflicks.platform.users.interfaces.rest;

import java.util.Date;

public record CreateUserResource(String name, String lastName, String userName, Date birthDate,
                                 String phone, String email, String password, String membership) {

    public CreateUserResource {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (userName == null || userName.isBlank()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        if (birthDate == null || birthDate.toString().isBlank()) {
            throw new IllegalArgumentException("Birth date cannot be null or empty");
        }

        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (membership == null || membership.isBlank()) {
            throw new IllegalArgumentException("Membership cannot be null or empty");
        }
    }

}

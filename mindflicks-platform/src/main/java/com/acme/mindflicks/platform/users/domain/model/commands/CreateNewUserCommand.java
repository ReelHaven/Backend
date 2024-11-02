package com.acme.mindflicks.platform.users.domain.model.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

public record CreateNewUserCommand(String name, String lastName, String userName, String birthDate, String phone, String email, String password, String membership) {
    public CreateNewUserCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("lastName cannot be null or empty");
        }
        if (userName == null || userName.isBlank()) {
            throw new IllegalArgumentException("userName cannot be null or empty");
        }
        if (birthDate == null ) {
            throw new IllegalArgumentException("birthDate cannot be null or empty");
        }
        if (phone == null || phone.isBlank()) {
            throw new IllegalArgumentException("phone cannot be null or empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email cannot be null or empty");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("password cannot be null or empty");
        }
        if (membership == null || membership.isBlank()) {
            throw new IllegalArgumentException("membership cannot be null or empty");
        }
    }
}

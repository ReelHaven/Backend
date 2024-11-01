package com.acme.mindflicks.platform.users.application.internal;

import com.acme.mindflicks.platform.users.domain.model.aggregates.User;
import com.acme.mindflicks.platform.users.domain.model.commands.CreateNewUserCommand;
import com.acme.mindflicks.platform.users.domain.services.UserCommandService;
import com.acme.mindflicks.platform.users.infrastucture.persistence.jpa.UserRepository;

import java.util.Optional;

public class UserServiceCommandImpl implements UserCommandService {

    private final UserRepository userRepository;

    public UserServiceCommandImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(CreateNewUserCommand command) {
        if(userRepository.existsUsersByEmail(command.email())) {
            throw new IllegalArgumentException("User already exists");
        }
        var user = new User(command);
        var createdUser = userRepository.save(user);
        return Optional.of(createdUser);
    }
}
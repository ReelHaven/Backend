package com.acme.mindflicks.platform.users.infrastucture.persistence.jpa;

import com.acme.mindflicks.platform.users.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User,Long> {

    Optional<User> findUserById(Long id);

    boolean existsUsersById(Long id);
}

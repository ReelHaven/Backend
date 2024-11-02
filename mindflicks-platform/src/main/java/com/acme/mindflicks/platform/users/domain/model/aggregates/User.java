package com.acme.mindflicks.platform.users.domain.model.aggregates;

import com.acme.mindflicks.platform.users.domain.model.commands.CreateNewUserCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User  extends AbstractAggregateRoot<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String name;

    @Getter
    private String lastName;

    @Getter
    private String userName;

    @Getter
    private String birthDate;

    @Getter
    private String phone;

    @Getter
    private String email;

    @Getter
    private String password;

    @Getter
    private String membership;


    protected User(){}

    public User(CreateNewUserCommand command) {
        this.name = command.name();
        this.lastName = command.lastName();
        this.userName = command.userName();
        this.birthDate = command.birthDate();
        this.phone = command.phone();
        this.email = command.email();
        this.password = command.password();
        this.membership = command.membership();

    }



}

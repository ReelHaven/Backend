package com.acme.mindflicks.platform.users.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.util.Date;

@Entity
public class User  extends AbstractAggregateRoot<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @Getter
    private String lastName;

    @Getter
    private String userName;

    @Getter
    private Date birthDate;

    @Getter
    private String phone;

    @Getter
    private String email;

    @Getter
    private String password;

    @Getter
    private String membership;


    protected User(){}

   // public User()



}

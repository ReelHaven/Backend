package com.acme.mindflicks.platform.users.interfaces.rest.resources;

import java.text.SimpleDateFormat;
import java.util.Date;

public record UserResource(Long id, String name, String lastName,
                           String userName, String birthDate, String phone,
                           String email, String password, String membership){}

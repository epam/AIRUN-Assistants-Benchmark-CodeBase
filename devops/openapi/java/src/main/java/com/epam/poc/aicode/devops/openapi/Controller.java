package com.epam.poc.aicode.devops.openapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping(value = "/users")
    public List<User> getListOfUsers() {
        return List.of(
            new User.Builder()
                .name("John Doe")
                .email("some-firstE@email.www")
                .password("some-password")
                .address("some-address")
                .phone("some-phone")
                .build(),
            new User.Builder()
                .name("Jane Doe")
                .email("some-secondE@email.www")
                .password("some-password2")
                .address("some-address2")
                .phone("some-phone2")
                .build(),
            new User.Builder()
                .name("Jane Doe")
                .email("some-thirdE@email.www")
                .password("some-password3")
                .address("some-address3")
                .phone("some-phone3")
                .build()
        );
    }
}

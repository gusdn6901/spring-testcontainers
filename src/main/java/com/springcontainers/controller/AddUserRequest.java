package com.springcontainers.controller;

import lombok.Getter;

@Getter
public class AddUserRequest {

    private String id;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;
    private String birth;
}

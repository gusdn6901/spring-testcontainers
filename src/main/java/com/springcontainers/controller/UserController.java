package com.springcontainers.controller;

import com.springcontainers.UserService;
import com.springcontainers.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Tag(name = "User", description = "User API")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get User", description = "Get user by seq.")
    @GetMapping("/user")
    public User getUser(@RequestParam long userSeq) {
        return userService.getUser(userSeq);
    }

    @Operation(summary = "Add User", description = "Add new user.")
    @PostMapping("/user")
    public User addUser(@RequestBody AddUserRequest request) {
        return userService.addUser(request);
    }

}

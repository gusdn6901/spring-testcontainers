package com.springcontainers;

import com.springcontainers.controller.AddUserRequest;
import com.springcontainers.entity.User;
import com.springcontainers.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(long userSeq) {
        return userRepository.findById(userSeq).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Transactional
    public User addUser(AddUserRequest request) {
        return userRepository.save(User.createNewUser(request.getId(), request.getPassword(), request.getEmail(), request.getName(), request.getPhoneNumber(), request.getBirth()));
    }
}

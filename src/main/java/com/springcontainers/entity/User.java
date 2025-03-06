package com.springcontainers.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth")
    private String birth;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public static User createNewUser(String id, String password, String email, String name, String phoneNumber, String birth) {
        User user = new User();
        user.id = id;
        user.password = password;
        user.email = email;
        user.name = name;
        user.phoneNumber = phoneNumber;
        user.birth = birth;
        user.createdAt = LocalDateTime.now();
        return user;
    }
}

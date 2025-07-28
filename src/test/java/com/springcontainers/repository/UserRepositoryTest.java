package com.springcontainers.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.springcontainers.SpringcontainersApplication;
import com.springcontainers.config.ContainerConfig;
import com.springcontainers.config.JpaTestConfig;
import com.springcontainers.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = SpringcontainersApplication.class)
@ActiveProfiles("test")
@Import({ContainerConfig.class, JpaTestConfig.class})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("UserRepository.save() Test")
    void save() {
        User user = User.createNewUser("testId", "testPw", "testEmail", "testName", "01012345678", "19990101");
        userRepository.save(user);

        User result = userRepository.findById(1L).orElse(null);
        System.out.println("User: " + result);
        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getPassword(), result.getPassword());
        assertEquals(user.getEmail(), result.getEmail());
        assertEquals(user.getName(), result.getName());
        assertEquals(user.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(user.getBirth(), result.getBirth());
        assertEquals(user.getCreatedAt(), result.getCreatedAt());
    }
}

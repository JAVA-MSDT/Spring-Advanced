package com.spring.dbconfig.repository;

import com.spring.dbconfig.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save_user_success() {
        User user = new User(1L, "username", "password");
        User userDb = userRepository.save(user);

        assertEquals(user.getUsername(), userDb.getUsername());
    }
}

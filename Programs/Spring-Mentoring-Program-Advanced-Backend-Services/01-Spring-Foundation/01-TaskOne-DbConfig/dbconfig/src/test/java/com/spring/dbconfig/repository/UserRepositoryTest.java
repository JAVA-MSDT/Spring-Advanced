package com.spring.dbconfig.repository;

import com.spring.dbconfig.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
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

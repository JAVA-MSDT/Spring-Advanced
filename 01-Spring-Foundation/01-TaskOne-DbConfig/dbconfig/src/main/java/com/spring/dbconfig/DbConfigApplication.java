package com.spring.dbconfig;

import com.spring.dbconfig.model.User;
import com.spring.dbconfig.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DbConfigApplication implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DbConfigApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User(1L, "username", "password");

        User userDb = userRepository.save(user);
        System.out.println("User DB:: " + userDb.getUsername());
    }
}

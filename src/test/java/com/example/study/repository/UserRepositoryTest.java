package com.example.study.repository;

import com.example.study.StudyApplicationTests;

import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {

    //DI
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
       User user = new User();

        user.setAccount("TestUser02");
        user.setEmail("TestUser02@email.com");
        user.setPhoneNumber("010-2222-2222");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser02");

        User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }
}

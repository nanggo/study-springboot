package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    //DI
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
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

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectedUser -> {
            System.out.println("User : " + selectedUser);
            System.out.print("email : " + selectedUser.getEmail());
        });

    }

    @Test
    @Transactional
    public void update() {
        Optional<User> user = userRepository.findById(3L);

        user.ifPresent(selectedUser ->{
            selectedUser.setAccount("pppp");
            selectedUser.setUpdatedAt(LocalDateTime.now());
            selectedUser.setUpdatedBy("Update method()");
            userRepository.save(selectedUser);
        });
    }

    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        Assert.assertTrue(user.isPresent());

        user.ifPresent(selectedUser ->{
            userRepository.delete(selectedUser);
        });

        Optional<User> deletedUser = userRepository.findById(1L);

        Assert.assertFalse(deletedUser.isPresent());
//        if (deletedUser.isPresent()){
//            System.out.println("User not deleted : " + deletedUser.get());
//        } else {
//            System.out.println("User deleted.");
//        }
    }
}

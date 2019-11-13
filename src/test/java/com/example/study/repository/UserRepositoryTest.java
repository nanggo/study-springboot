package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
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
//    @Transactional
    public void create() {
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {
        String phoneNumber = "010-111-2222";
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);
        Assert.assertNotNull(user);
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

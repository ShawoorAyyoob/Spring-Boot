package com.shawoor.topsecurity.service;

import com.shawoor.topsecurity.model.User;
import com.shawoor.topsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(5);
        String rawPassword = user.getPassword();
        String hashedPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(hashedPassword);
        return this.userRepository.save(user);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}

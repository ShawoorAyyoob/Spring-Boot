package com.shawoor.topsecurity.service;

import com.shawoor.topsecurity.model.User;
import com.shawoor.topsecurity.model.UserPrincipal;
import com.shawoor.topsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired

    public CustomUserDetailsService(UserRepository repository) {
        this.userRepository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUserName(username);
        UserDetails userPrincipal = new UserPrincipal(user);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return userPrincipal;
    }
}

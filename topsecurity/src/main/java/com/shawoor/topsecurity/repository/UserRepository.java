package com.shawoor.topsecurity.repository;

import com.shawoor.topsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}

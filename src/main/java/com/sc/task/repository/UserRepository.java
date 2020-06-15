package com.sc.task.repository;

import com.sc.task.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameEquals(String username);
}

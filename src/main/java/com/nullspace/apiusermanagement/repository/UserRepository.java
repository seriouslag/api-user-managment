package com.nullspace.apiusermanagement.repository;

import com.nullspace.apiusermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    boolean existsById(Long Id);
}


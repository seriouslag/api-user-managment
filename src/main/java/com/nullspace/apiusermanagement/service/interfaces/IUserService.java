package com.nullspace.apiusermanagement.service.interfaces;

import com.nullspace.apiusermanagement.model.User;

import java.util.List;

public interface IUserService extends ICrudService<User, Long> {
    User update(User user);

    User findById(Long id);

    User findByUsername(String username);

    boolean existsByUsername(String username);

    List<User> findAll();

    boolean exists(Long id);
}

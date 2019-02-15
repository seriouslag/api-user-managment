package com.nullspace.apiusermanagement.service.interfaces;

import com.nullspace.apiusermanagement.model.User;

import java.util.List;

public interface IUserService extends ICrudService<User, Long> {
    User update(User user);

    User findById(Long id);

    User findByUsername(String username);

    List<User> findAll();

    Boolean exists(Long id);
}

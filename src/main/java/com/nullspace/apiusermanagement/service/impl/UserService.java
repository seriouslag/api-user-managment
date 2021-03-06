package com.nullspace.apiusermanagement.service.impl;

import com.nullspace.apiusermanagement.model.Exceptions.HttpExceptions.NotFound;
import com.nullspace.apiusermanagement.model.User;
import com.nullspace.apiusermanagement.repository.UserRepository;
import com.nullspace.apiusermanagement.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findById(Long id) throws AccessDeniedException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id was not found"));
    }

    @Override
    public boolean exists(Long id) {
        return userRepository.existsById(id);
    }


    @Override
    public User update(User updatedUser) {
        User oldUser = userRepository.findById(updatedUser.getId()).orElseThrow(NotFound::new);
        if (!updatedUser.getFirstName().isEmpty()) {
            oldUser.setFirstName(updatedUser.getFirstName());
        }
        if (!updatedUser.getLastName().isEmpty()) {
            oldUser.setLastName(updatedUser.getLastName());
        }

        if (!updatedUser.getEmail().isEmpty()) {
            oldUser.setEmail(updatedUser.getEmail());
        }

        oldUser.setEnabled(updatedUser.isEnabled());
        userRepository.save(oldUser);
        return oldUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    @Override
    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }
}

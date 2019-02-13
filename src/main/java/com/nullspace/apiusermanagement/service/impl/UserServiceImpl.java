package com.nullspace.apiusermanagement.service.impl;

import com.nullspace.apiusermanagement.model.User;
import com.nullspace.apiusermanagement.repository.UserRepository;
import com.nullspace.apiusermanagement.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername( String username ) throws UsernameNotFoundException {
        return userRepository.findByUsername( username );
    }

    public User findById( Long id ) throws AccessDeniedException {
        return userRepository.findById( id )
                .orElseThrow(() -> new UsernameNotFoundException("User with id was not found"));
    }

    @Override
    public User save(User object) {
        userRepository.save(object);
        return object;
    }

    @Override
    public void delete(User object) {
        userRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userRepository.deleteById(aLong);
    }

    public List<User> findAll() throws AccessDeniedException {
        return userRepository.findAll();
    }
}

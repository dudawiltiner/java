package com.challenge.service.impl;

import com.challenge.entity.User;
import com.challenge.service.interfaces.UserServiceInterface;
import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User object) {
        return this.userRepository.save(object);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return this.userRepository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return this.userRepository.findByAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return this.userRepository.findByCompanyId(companyId);
    }
}

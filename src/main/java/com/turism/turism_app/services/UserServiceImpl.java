package com.turism.turism_app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turism.turism_app.models.entities.Users;
import com.turism.turism_app.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Users> findAll() {
        return (List<Users>)userRepository.findAll();
    }
    


}

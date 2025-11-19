package com.turism.turism_app.services;

import java.util.List;
import java.util.Optional;

import com.turism.turism_app.models.entities.Users;

public interface UserService {

    List<Users> findAll();

    Optional<Users> findByEmail(String email);
    
}

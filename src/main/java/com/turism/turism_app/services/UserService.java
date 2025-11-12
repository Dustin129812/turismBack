package com.turism.turism_app.services;

import java.util.List;

import com.turism.turism_app.models.entities.Users;

public interface UserService {

    List<Users> findAll();
}

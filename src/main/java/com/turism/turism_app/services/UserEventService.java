package com.turism.turism_app.services;

import java.util.List;
import java.util.Optional;

import com.turism.turism_app.models.entities.UserEvents;

public interface UserEventService {

    List<UserEvents> findAll();

    UserEvents save(UserEvents userEvent);

    void remove(Long id);

    Optional<UserEvents> update(UserEvents userEvent,Long id);

}

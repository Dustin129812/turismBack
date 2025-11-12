package com.turism.turism_app.services;

import java.util.List;
import java.util.Optional;

import com.turism.turism_app.models.entities.Events;

public interface EventService {

    List<Events> findAll();

    Events save(Events event);

    void remove(Long id);

    Optional<Events> update(Events event ,Long id);

}

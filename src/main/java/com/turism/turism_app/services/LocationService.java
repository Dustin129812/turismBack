package com.turism.turism_app.services;

import java.util.List;
import java.util.Optional;

import com.turism.turism_app.models.entities.Locations;

public interface LocationService {

    List<Locations> findAll();

    Locations save(Locations location);

    void remove(Long id);

    Optional<Locations> update(Locations location,Long id);

}

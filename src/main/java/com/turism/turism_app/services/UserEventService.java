package com.turism.turism_app.services;

import java.util.List;
import java.util.Optional;

import com.turism.turism_app.dto.EventUserDTO;
import com.turism.turism_app.models.entities.UserEvents;

public interface UserEventService {

    List<UserEvents> findAll();

    UserEvents save(Long userId, Long eventId);

    void remove(Long id);

    Optional<UserEvents> update(UserEvents userEvent,Long id);

    List<UserEvents> findByUserId(Long userId); 
    List<EventUserDTO> getEventDTOsByUser(Long userId);
    

}

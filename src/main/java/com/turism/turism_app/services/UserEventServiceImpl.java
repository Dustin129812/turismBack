package com.turism.turism_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turism.turism_app.dto.EventUserDTO;
import com.turism.turism_app.models.entities.Events;
import com.turism.turism_app.models.entities.UserEvents;
import com.turism.turism_app.models.entities.Users;
import com.turism.turism_app.repositories.EventRepository;
import com.turism.turism_app.repositories.UserEventRepository;
import com.turism.turism_app.repositories.UserRepository;

@Service
public class UserEventServiceImpl implements UserEventService {
    @Autowired
    UserEventRepository userEventRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;

    @Override
    public List<UserEvents> findAll() {
        
        return (List<UserEvents>) userEventRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        userEventRepository.deleteById(id);
        
    }

    @Override
    public UserEvents save(Long userId, Long eventId) {

    boolean exists = userEventRepository.existsByUserIdAndEventId(userId, eventId);

    if (exists) {
        throw new RuntimeException("Este evento ya está seleccionado por el usuario");
    }

        Users user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    Events event = eventRepository.findById(eventId)
            .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

    UserEvents ue = new UserEvents();
    ue.setUser(user);
    ue.setEvent(event);

    return userEventRepository.save(ue);
}

    @Override
    public Optional<UserEvents> update(UserEvents userEvent, Long id) {
        return userEventRepository.findById(id).map(exist->{
            exist.setEvent(userEvent.getEvent());
            exist.setUser(userEvent.getUser());

            UserEvents updateUserEvents= userEventRepository.save(exist);
            return updateUserEvents; 
        });
    }

    @Override
    public List<UserEvents> findByUserId(Long userId) {
        return userEventRepository.findByUserId(userId);
    }

    public List<EventUserDTO> getEventDTOsByUser(Long userId) {
    List<UserEvents> userEvents = userEventRepository.findByUserId(userId);

    return userEvents.stream()
        .map(ue -> {
            Events event = ue.getEvent();
            return new EventUserDTO(
                ue.getId(),                          
                event.getId(),
                event.getDescription(),
                event.getDate(),
                event.getStartHour(),
                event.getEndHour(),
                event.getPhotoPath(),
                (event.getLocation() != null ? event.getLocation().getName() : null),
                (event.getLocation() != null ? event.getLocation().getLatitude() : null),
                (event.getLocation() != null ? event.getLocation().getLongitude() : null)
            );
        })
        .toList();
}



}

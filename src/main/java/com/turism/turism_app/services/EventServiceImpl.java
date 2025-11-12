package com.turism.turism_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turism.turism_app.models.entities.Events;
import com.turism.turism_app.repositories.EventRepository;
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Events> findAll() {
        return (List<Events>) eventRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        eventRepository.deleteById(id);
        
    }

    @Override
    public Events save(Events event) {
        
        return eventRepository.save(event);
    }

    @Override
    public Optional<Events> update(Events event, Long id) {
        
        return eventRepository.findById(id).map(exist->{
            exist.setDate(event.getDate());
            exist.setDescription(event.getDescription());
            exist.setEndHour(event.getEndHour());
            exist.setLocation(event.getLocation());
            exist.setStartHour(event.getStartHour());
            
            Events updateEvent= eventRepository.save(exist);
            return updateEvent;
        });
    }

}

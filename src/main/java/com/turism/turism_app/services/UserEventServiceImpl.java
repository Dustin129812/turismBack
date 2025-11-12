package com.turism.turism_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turism.turism_app.models.entities.UserEvents;
import com.turism.turism_app.repositories.UserEventRepository;

@Service
public class UserEventServiceImpl implements UserEventService {
    @Autowired
    UserEventRepository userEventRepository;

    @Override
    public List<UserEvents> findAll() {
        
        return (List<UserEvents>) userEventRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        userEventRepository.deleteById(id);
        
    }

    @Override
    public UserEvents save(UserEvents userEvent) {
        
        return userEventRepository.save(userEvent);
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

}

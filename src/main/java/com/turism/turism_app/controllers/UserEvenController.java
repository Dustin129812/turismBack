package com.turism.turism_app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turism.turism_app.dto.EventUserDTO;
import com.turism.turism_app.dto.UserEventDTO;
import com.turism.turism_app.models.entities.UserEvents;
import com.turism.turism_app.models.entities.Users;
import com.turism.turism_app.services.EventServiceImpl;
import com.turism.turism_app.services.UserEventServiceImpl;
import com.turism.turism_app.services.UserServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/userEvent")
public class UserEvenController {

    @Autowired
    UserEventServiceImpl userEventServiceImpl;
    @Autowired
    EventServiceImpl eventServiceImpl;
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping("/list")
    public List<UserEvents>list() {
        return userEventServiceImpl.findAll();
    }

    @GetMapping("/byUser/{email}")
public List<EventUserDTO> getEventsByUserEmail(@PathVariable String email) {
    Users user = userServiceImpl.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    return userEventServiceImpl.getEventDTOsByUser(user.getId());
}


    @PostMapping("/add")
    public UserEvents save(@RequestBody UserEventDTO dto) {
        Users user= userServiceImpl.findByEmail(dto.getUserName()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
    return userEventServiceImpl.save(user.getId(), dto.getEventId());
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable Long id ) {
        userEventServiceImpl.remove(id);
    }
    
    @PutMapping("update/{id}")
    public Optional<UserEvents>update(@PathVariable Long id, @RequestBody UserEvents userEvent) {
        return userEventServiceImpl.update(userEvent, id);
    }
    
    
}

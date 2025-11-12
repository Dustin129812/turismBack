package com.turism.turism_app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turism.turism_app.models.entities.UserEvents;
import com.turism.turism_app.services.UserEventServiceImpl;


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

    @GetMapping("7list")
    public List<UserEvents>list() {
        return userEventServiceImpl.findAll();
    }

    @PostMapping("/add")
    public UserEvents save(@RequestBody UserEvents userEvent) {
    return userEventServiceImpl.save(userEvent);
    }

    @PostMapping("/delete/{id}")
    public void remove(@PathVariable Long id ) {
        userEventServiceImpl.remove(id);
    }
    
    @PutMapping("update/{id}")
    public Optional<UserEvents>update(@PathVariable Long id, @RequestBody UserEvents userEvent) {
        return userEventServiceImpl.update(userEvent, id);
    }
    
    
}

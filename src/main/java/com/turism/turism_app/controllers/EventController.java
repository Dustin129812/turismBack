package com.turism.turism_app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turism.turism_app.models.entities.Events;
import com.turism.turism_app.services.EventServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventServiceImpl eventServiceImpl;

    @GetMapping("/list")
    public List<Events>list () {
        return eventServiceImpl.findAll();
    }

    @PostMapping("/add")
    public Events save(@RequestBody Events event) {
        
        return eventServiceImpl.save(event);
    }

    @PostMapping("/delete/{id}")
    public void remove(@PathVariable Long id) {
        eventServiceImpl.remove(id);
    }

    @PutMapping("update/{id}")
    public Optional<Events> update(@PathVariable Long id, @RequestBody Events event) {
        return eventServiceImpl.update(event, id);
    }
    
    
    

}

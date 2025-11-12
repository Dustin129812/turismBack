package com.turism.turism_app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turism.turism_app.models.entities.Locations;
import com.turism.turism_app.services.LocationServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationServiceImpl locationServiceImpl;

    @GetMapping("/list")
    public List<Locations>finAll() {
        return locationServiceImpl.findAll();
    }

    @PostMapping("/add")
    public Locations save(@RequestBody Locations location) {
        
        
        return locationServiceImpl.save(location);
    }
    
    @PostMapping("/delete/{id}")
    public void remove(@RequestBody Long id) {
        locationServiceImpl.remove(id);
    }

    @PutMapping("update/{id}")
    public Optional<Locations> update(@PathVariable Long id, @RequestBody Locations location) {
    
        return locationServiceImpl.update(location, id);

    }
    
    
    
}

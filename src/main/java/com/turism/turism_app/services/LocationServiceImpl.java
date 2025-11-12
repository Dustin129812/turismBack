package com.turism.turism_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turism.turism_app.models.entities.Locations;
import com.turism.turism_app.repositories.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Locations> findAll() {
        
        return (List<Locations>) locationRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        locationRepository.deleteById(id);
        
    }

    @Override
    public Locations save(Locations location) {
        
        return locationRepository.save(location);
    }

    @Override
    public Optional<Locations> update(Locations location, Long id) {
        
        return locationRepository.findById(id).map(exist->{
            exist.setLatitude(location.getLatitude());
            exist.setLongitude(location.getLongitude());
            exist.setName(location.getName());

            Locations updateLocation = locationRepository.save(exist);
            return updateLocation;
        });
    }

    

}

package com.turism.turism_app.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turism.turism_app.dto.EventDTO;
import com.turism.turism_app.models.entities.Events;
import com.turism.turism_app.models.entities.Locations;
import com.turism.turism_app.services.EventServiceImpl;
import com.turism.turism_app.services.LocationServiceImpl;

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
    @Autowired
    private LocationServiceImpl locationServiceImpl;

    @GetMapping("/list")
    public List<Events>list () {
        return eventServiceImpl.findAll();
    }

    @PostMapping("/add")
    public Events save(@RequestBody EventDTO dto) {

    // 1. Buscar la locación por ID
        Locations location = locationServiceImpl
                .findById(dto.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location no encontrada"));
    String filePath = null;

    if (dto.getPhotoPath() != null && dto.getPhotoPath().startsWith("data:image")) {

        try {
            // quitar encabezado data:image/jpeg;base64,
            String base64Image = dto.getPhotoPath().split(",")[1];

            byte[] imageBytes = java.util.Base64.getDecoder().decode(base64Image);

            String fileName = "event_" + System.currentTimeMillis() + ".jpg";

            String uploadDir = "uploads/";
            java.nio.file.Path path = java.nio.file.Paths.get(uploadDir + fileName);

            java.nio.file.Files.write(path, imageBytes);

            filePath = uploadDir + fileName; 

        } catch (Exception e) {
            throw new RuntimeException("Error al guardar imagen: " + e.getMessage());
        }
    }
    // 2. Crear un evento nuevo
        Events event = new Events();
        event.setLocation(location);
        event.setDescription(dto.getDescription());
        event.setStartHour(dto.getStartHour());
        event.setEndHour(dto.getEndHour());
        event.setPhotoPath(filePath);
    // convertir String → Timestamp
        event.setDate(Timestamp.valueOf(dto.getDate() + " 00:00:00"));
    // 3. Guardar
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

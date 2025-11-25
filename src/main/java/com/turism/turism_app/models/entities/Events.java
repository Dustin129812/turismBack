package com.turism.turism_app.models.entities;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations location;
    
    private String description;
    
    private Timestamp date;
    
    private String startHour;
    
    private String endHour;

    private String photoPath;

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @OneToMany(mappedBy = "event" , cascade = CascadeType.REMOVE)
    private List<UserEvents> userEvents;

    public Events() {
    }

    public Long getId() {
        return id;
    }
    
    public Locations getLocation() {
        return location;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Timestamp getDate() {
        return date;
    }
    
    public String getStartHour() {
        return startHour;
    }
    
    public String getEndHour() {
        return endHour;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
}

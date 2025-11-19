package com.turism.turism_app.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Events event;


    public UserEvents(Long id, Users user, Events event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setEvent(Events event) {
        this.event = event;
    }


    public UserEvents() {
    }

    public Long getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public Events getEvent() {
        return event;
    }

}

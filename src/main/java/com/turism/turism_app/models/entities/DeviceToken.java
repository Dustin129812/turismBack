package com.turism.turism_app.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class DeviceToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    private String token;
    private Boolean active = true;
    public Long getId() {
        return id;
    }
    public Users getUserId() {
        return user;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Users user) {
        this.user = user;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public String getToken() {
        return token;
    }
    public Boolean getActive() {
        return active;
    }


}

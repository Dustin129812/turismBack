package com.turism.turism_app.models.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    private String email;

    private String password;

    private String country;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String phone;

    public Users() {
    }

    @OneToMany(mappedBy = "user")
    private List<UserEvents> userEvents;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<DeviceToken> deviceTokens;
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getCountry() {
        return country;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public String getPhone() {
        return phone;
    }
    

}
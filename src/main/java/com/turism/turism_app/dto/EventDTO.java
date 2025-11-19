package com.turism.turism_app.dto;

public class EventDTO {
    private Long locationId;
    private String description;
    private String date;
    private String startHour;
    private String endHour;
    private String photoPath;
    
    public Long getLocationId() {
        return locationId;
    }
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getStartHour() {
        return startHour;
    }
    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }
    public String getEndHour() {
        return endHour;
    }
    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }
    public String getPhotoPath() {
        return photoPath;
    }
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}

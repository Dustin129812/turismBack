package com.turism.turism_app.dto;

import java.sql.Timestamp;

public class EventUserDTO {
    private Long userEventId;   // <--- ID de user_events
    private Long eventId;
    private String description;
    private Timestamp date;
    private String startHour;
    private String endHour;
    private String photoPath;
    private String locationName;
    private Double lat;
    private Double lng;
    
    public EventUserDTO() {}
    
    public EventUserDTO(Long userEventId, Long eventId, String description, Timestamp date,
        String startHour, String endHour,String photoPath, String locationName, Double lat,
        Double lng) {
            
            this.userEventId = userEventId;
            this.eventId = eventId;
            this.description = description;
            this.date = date;
            this.startHour = startHour;
            this.endHour = endHour;
            this.photoPath = photoPath;
            this.locationName = locationName;
            this.lat = lat;
            this.lng =lng;
        }
        
        public Long getUserEventId() {
            return userEventId;
        }
    
        public Long getEventId() {
            return eventId;
        }
        
        public void setUserEventId(Long userEventId) {
            this.userEventId = userEventId;
        }
    
        public void setEventId(Long eventId) {
            this.eventId = eventId;
        }
        public void setLat(Double lat) {
            this.lat = lat;
        }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
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
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
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
    public String getPhotoPath() {
        return photoPath;
    }
    public String getLocationName() {
        return locationName;
    }
}

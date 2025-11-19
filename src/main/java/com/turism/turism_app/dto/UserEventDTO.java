package com.turism.turism_app.dto;

public class UserEventDTO {
    private String userName;
    private Long eventId;
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public String getUserName() {
        return userName;
    }
    public Long getEventId() {
        return eventId;
    }
}

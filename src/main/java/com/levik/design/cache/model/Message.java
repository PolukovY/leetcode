package com.levik.design.cache.model;

import com.levik.design.cache.TimeMarker;

public class Message implements TimeMarker {

    private String user;
    private String message;
    private long timeMillis;

    public Message(String user, String message, long timeMillis) {
        this.user = user;
        this.message = message;
        this.timeMillis = timeMillis;
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public long getTimeMillis() {
        return timeMillis;
    }


    @Override
    public String toString() {
        return "Message{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                ", timeMillis=" + timeMillis +
                '}';
    }
}

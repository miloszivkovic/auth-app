package com.common.models;

import java.util.Date;

public class Session {
    // TODO: use UUID
    private String sessionId;

    private String username;

    private Date expirationDate;

    public Session(String sessionId, String username, Date expirationDate) {
        this.sessionId = sessionId;
        this.username = username;
        this.expirationDate = expirationDate;
    }

    public Session() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUsername() {
        return username;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public boolean isExpired() {
        return getExpirationDate().before(new Date());
    }
}

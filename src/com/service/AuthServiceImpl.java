package com.service;

import com.common.models.Session;
import com.persistence.dao.SessionDao;

import javax.inject.Inject;
import java.util.Date;

public class AuthServiceImpl implements AuthService {
    private final SessionDao sessionDao;

    @Inject
    public AuthServiceImpl(SessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @Override
    public String getCurrentUser(String sessionId) {
        if (sessionId == null) {
            return null;
        }

        Session currentSession = sessionDao.getById(sessionId);
        if (currentSession.getExpirationDate().after(new Date())) {
            return currentSession.getUsername();
        }

        return null;
    }
}

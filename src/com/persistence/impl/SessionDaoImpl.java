package com.persistence.impl;

import com.common.HttpConstants;
import com.common.models.Session;
import com.persistence.dao.SessionDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

// TODO: implement properly, remove mocks
public class SessionDaoImpl implements SessionDao {
    public SessionDaoImpl() {
    }

    @Override
    public Session getById(String sessionId) {
        if (sessionId == null) {
            return new Session();
        }

        Date date;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2025");
        } catch (ParseException ex) {
            date = null;
        }

        return new Session(sessionId, "meekree", date);
    }

    @Override
    public Session createSession(String username) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.HOUR, HttpConstants.DEFAULT_SESSION_LIFETIME_HOURS);
        Date d = c.getTime();

        return new Session(UUID.randomUUID().toString(), username, d);
    }
}

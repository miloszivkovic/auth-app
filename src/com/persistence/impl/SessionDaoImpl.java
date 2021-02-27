package com.persistence.impl;

import com.common.models.Session;
import com.persistence.dao.SessionDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: implement properly
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
}

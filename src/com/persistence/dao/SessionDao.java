package com.persistence.dao;

import com.common.models.Session;

public interface SessionDao {
    Session getById(String sessionId);
}

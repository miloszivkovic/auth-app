package com.service;

import com.common.models.Session;

public interface AuthService {
    String getCurrentUser(String sessionId);

    Session createSession(String username);
}

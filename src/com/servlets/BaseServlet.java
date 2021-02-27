package com.servlets;

import com.common.CookieName;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

public class BaseServlet extends HttpServlet {
    public Cookie[] getCookies(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        return cookies != null ? cookies : new Cookie[]{};
    }

    public Cookie getCookieByName(HttpServletRequest req, CookieName cookieName) {
        Cookie[] cookies = getCookies(req);
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName.toString())) {
                return cookie;
            }
        }
        return null;
    }

    public String getCookieValueByCookieName(HttpServletRequest req, CookieName cookieName) {
        Cookie cookie = getCookieByName(req, cookieName);
        if (cookie == null) {
            return null;
        }
        return cookie.getValue();
    }
}

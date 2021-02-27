package com.servlets;

import com.common.CookieName;
import com.common.HttpConstants;
import com.common.models.Session;
import com.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/whoami")
public class WhoAmIServlet extends BaseServlet {
    @Inject
    private AuthService authService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: check security questions regarding session ids in cookies etc
        // TODO: replace with proper dto
        String currentUser = null;
        String sessionId = getCookieValueByCookieName(req, CookieName.SESSION);
        if (sessionId != null) {
            currentUser = authService.getCurrentUser(sessionId);
        }

        resp.setContentType(HttpConstants.TEXT_HTML);

        if (currentUser != null) {
            Session newSession = authService.createSession(currentUser);
            resp.addCookie(new Cookie(CookieName.SESSION.toString(), newSession.getSessionId()));
        }

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Who am I</title></head>");
        out.println("<body>");
        if (currentUser != null) {
            out.println(String.format("<p>Hello %s</p>", currentUser));
        } else {
            out.println("<p>No idea who you are</p>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

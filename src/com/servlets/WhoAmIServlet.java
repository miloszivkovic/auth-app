package com.servlets;

import com.common.CookieName;
import com.common.HttpConstants;
import com.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
        resp.setContentType(HttpConstants.TEXT_HTML);

        // TODO: replace with proper dto
        String currentUser = null;
        String sessionId = getCookieValueByCookieName(req, CookieName.SESSION);
        if (sessionId != null) {
            currentUser = authService.getCurrentUser(sessionId);
        }

        // TODO: session refresh - set user's cookie to new session
        // TODO: extract html formatting somewhere?

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

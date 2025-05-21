package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        StringBuilder jsonResponse = new StringBuilder("{");
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (jsonResponse.length() > 1) {
                    jsonResponse.append(",");
                }
                jsonResponse
                    .append("\"")
                    .append(cookie.getName())
                    .append("\":\"")
                    .append(cookie.getValue())
                    .append("\"");
            }
        } else {
            jsonResponse.append("\"message\":\"No cookies found\"");
        }

        jsonResponse.append("}");
        out.print(jsonResponse.toString());
        out.flush();
    }
}

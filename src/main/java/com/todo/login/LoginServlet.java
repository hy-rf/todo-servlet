package com.todo.login;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        request
            .getRequestDispatcher("/WEB-INF/login.jsp")
            .forward(request, response);
    }

    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Read JSON request body
        StringBuilder jsonRequest = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonRequest.append(line);
            }
        }

        // Parse JSON request body
        Gson gson = new Gson();
        JsonObject requestBody = gson.fromJson(
            jsonRequest.toString(),
            JsonObject.class
        );

        // Respond with the same JSON content
        String jsonResponse = gson.toJson(requestBody);
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}

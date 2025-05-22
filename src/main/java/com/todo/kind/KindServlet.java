package com.todo.kind;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/kind")
public class KindServlet extends HttpServlet {

    private static class SimpleObject {

        private String message;
        private int code;

        public SimpleObject(String message, int code) {
            this.message = message;
            this.code = code;
        }
    }

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String name = request.getParameter("name");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Create a simple object
        SimpleObject obj = new SimpleObject("This is a JSON response", 200);

        // Convert the object to JSON
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(obj);

        // Write the JSON response
        response.getWriter().write(jsonResponse);
    }
}

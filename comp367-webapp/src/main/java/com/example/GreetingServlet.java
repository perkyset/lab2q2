package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet("/greeting")
public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "Dmytro";
        String greeting = getGreeting(name);

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>" + greeting + "</h1>");
        response.getWriter().println("</body></html>");
    }

    private String getGreeting(String name) {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();

        if (hour < 12) {
            return "Good morning, " + name + ", Welcome to COMP367";
        } else {
            return "Good afternoon, " + name + ", Welcome to COMP367";
        }
    }
}
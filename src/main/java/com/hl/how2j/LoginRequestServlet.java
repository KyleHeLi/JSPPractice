package com.hl.how2j;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginRequestServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 3341973259317563543L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("The complete URL of a host that sends requests: " + request.getRequestURL());
        System.out.println("The URI of a host that sends requests: " + request.getRequestURI());
        System.out.println("The parameters in query: " + request.getQueryString());
        System.out.println("The IP address: " + request.getRemoteAddr());
        System.out.println("The hostname: " + request.getRemoteHost());
        System.out.println("The port: " + request.getRemotePort());
        System.out.println("The method of request: " + request.getMethod());
        
        String html = null;
        
        if ("admin".equals(username) && "123".equals(password)) {
            html = "<div style=\"color:green\">Login Success</div>";
        } else {
            html = "<div style=\"color:red\">Login Fail</div>";
        }
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(html);
    }
}

package com.hl.how2j;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1072959192875706864L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("Username: " + username);
        System.out.println("Passwrod: " + password);
        
        String html = null;
        if ("admin".equals(username) && "123".equals(password)) {
            html = "<div style=\"color:green\">success</div>";
        } else {
            html = "<div style=\"color:red\">failed</div>";
        }
        
        PrintWriter out = response.getWriter();
        out.println(html);
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

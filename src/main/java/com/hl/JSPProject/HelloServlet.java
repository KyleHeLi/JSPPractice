package com.hl.JSPProject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -366407372220388227L;
	private String message;

    public void init() throws ServletException {
        System.out.println("init of Hello Servlet");
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Actual logic
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>Hello Servlet!</h2>");
        out.println(new Date().toString());
    }

    public void destroy() {
    	// Try to do something
    }
}


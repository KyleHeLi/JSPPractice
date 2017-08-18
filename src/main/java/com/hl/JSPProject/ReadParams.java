package com.hl.JSPProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadParams extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 6045787516455654243L;

    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String newLine = "\n";

        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String title = "Reading All Form Parameters";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">" + newLine;

        out.println(docType + "<html>" + newLine + "<head><title>" + title + "</title></head>" + newLine + "<body bgcolor = \"#f0f0f0\">"
                + newLine + "<h1 align = \"center\">" + title + "</h1>" + newLine
                + "<table width = \"100%\" border = \"1\" align = \"center\">" + newLine + "<tr bgcolor = \"#949494\">" + newLine
                + "<th>Param Name</th>" + "<th>Param Value(s)</th>" + newLine + "</tr>" + newLine);

        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            out.println("<tr><td>" + paramName + "</td>" + newLine + "<td>");
            String[] paramValues = request.getParameterValues(paramName);

            // Read single valued data
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) {
                    out.println("<i>No Value</i>");
                } else {
                    out.println(paramValue);
                }
            } else {
                // Read multiple valued data
                out.println("<ul>");

                for (int i = 0; i < paramValues.length; i++) {
                    out.println("<li>" + paramValues[i]);
                }
                out.println("</ul>");
            }
        }
        out.println("</tr>" + newLine + "</table>" + newLine + "</body>" + newLine + "</html>");
    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private String message;

    public void init() {
        message = "Hello 333 World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        logger.info("HelloServlet - Begin");

        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        logger.info("HelloServlet - End");
    }

    public void destroy() {
    }
}
package com.example.banken;

import DomianObjects.Konto;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String msg = "her er en oversigt over konti";

        request.setAttribute("msg",msg);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
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

    Map<String, Konto> kontiMap = new TreeMap<>();

    public void init() {
        Konto konto1 = new Konto("nicolai","1",150);
        Konto konto2 = new Konto("denis","1",15);
        Konto konto3 = new Konto("betyl","1",170);
        Konto konto4 = new Konto("long","1",15);
        Konto konto5 = new Konto("kristoffer","1",1500);
        Konto konto6 = new Konto("søren","1",2157);

        kontiMap.put(konto1.getNavn(),konto1);
        kontiMap.put(konto2.getNavn(),konto2);
        kontiMap.put(konto3.getNavn(),konto3);
        kontiMap.put(konto4.getNavn(),konto4);
        kontiMap.put(konto5.getNavn(),konto5);
        kontiMap.put(konto6.getNavn(),konto6);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();

        servletContext.setAttribute("kontiMap",kontiMap);

        String msg = "her er en oversigt over konti";

        request.setAttribute("msg",msg);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
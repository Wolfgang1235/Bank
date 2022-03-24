import DomianObjects.Konto;
import DomianObjects.TransaktionsListe;
import DomianObjects.TransaktionsObjekt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "LogIn", value = "/LogIn")
public class LogInServlet extends HttpServlet {

    Map<String, Konto> kontiMap = new TreeMap<>();

    public void init() {
        Konto konto1 = new Konto("nicolai","1",101,150,new TransaktionsListe(new ArrayList<>()));
        Konto konto2 = new Konto("denis","1",102,15,new TransaktionsListe(new ArrayList<>()));
        Konto konto3 = new Konto("betyl","1",103,170,new TransaktionsListe(new ArrayList<>()));
        Konto konto4 = new Konto("long","1",104,15,new TransaktionsListe(new ArrayList<>()));
        Konto konto5 = new Konto("kristoffer","1",105,1500,new TransaktionsListe(new ArrayList<>()));
        Konto konto6 = new Konto("søren","1",106,2157,new TransaktionsListe(new ArrayList<>()));

        kontiMap.put(konto1.getNavn(),konto1);
        kontiMap.put(konto2.getNavn(),konto2);
        kontiMap.put(konto3.getNavn(),konto3);
        kontiMap.put(konto4.getNavn(),konto4);
        kontiMap.put(konto5.getNavn(),konto5);
        kontiMap.put(konto6.getNavn(),konto6);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String navn = request.getParameter("navn");
        String kode = request.getParameter("koden");

        HttpSession session = request.getSession();
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("kontiMap",kontiMap);

        if (getServletContext().getAttribute("kontiMap") == null) {

        }

        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("kontiMap");

        String fejlBesked;


        Konto konto = kontoMap.getOrDefault(navn, null);
        if (konto == null) {
            fejlBesked = "Kontoen fandtes ikke";
            request.setAttribute("fejl",fejlBesked);

            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


        int forsøg = 0;
        log("Antal forsøg før try/catch"+forsøg);
        try {
            forsøg = Integer.parseInt(String.valueOf( session.getAttribute("forsøg")));
            log("Efter try/catch"+forsøg);
        } catch (NumberFormatException e) {
            forsøg = 0;
        }

        while (forsøg < 3 && !konto.getKode().equals(kode)) {
            if (!konto.getKode().equals(kode)) {

                fejlBesked = "dit password er forkert, prøv igen";
                request.setAttribute("fejl",fejlBesked);
                forsøg++;
                session.setAttribute("forsøg",forsøg);
                log("Vi er i while loopet "+forsøg);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }

        if (konto.getKode().equals(kode)) {
            forsøg = 0;
            session.setAttribute("forsøg",forsøg);
        }

        if (forsøg==3) {
            fejlBesked = "Din tåbe nu har du forsøgt 3 gange...helt ærligt mand/dame";
            request.setAttribute("fejl",fejlBesked);

            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        session = request.getSession();
        session.setAttribute("navn",navn);
        session.setAttribute("konto",konto);

        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
        //
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
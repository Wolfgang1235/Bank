import DomianObjects.BrugerListe;
import DomianObjects.Konto;
import DomianObjects.TransaktionsListe;
import DomianObjects.TransaktionsObjekt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@WebServlet(name = "ServletOpretBruger", value = "/ServletOpretBruger")
public class ServletOpretBruger extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();
        HttpSession session = request.getSession();
        String handling = request.getParameter("handling");
        String fejlBesked;
        log(handling);

        if (handling.equals("Opret ny bruger")) {
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);
        }
        if (handling.equals("opret")) {
            String navn = request.getParameter("navn");

            Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("kontiMap");
            if (kontoMap.containsKey(navn)) {
                fejlBesked = "Brugernavn er allerede taget, vælg et nyt";
                request.setAttribute("fejl",fejlBesked);

                request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);
            }

            if (!request.getParameter("pwd1").equals(request.getParameter("pwd2"))) {
                fejlBesked = "De 2 password er ikke ens!";
                request.setAttribute("fejl",fejlBesked);

                request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);
            }

            List<Integer> kontoNumre = new ArrayList<>();
            kontoMap.forEach((k,v) -> {
                kontoNumre.add(v.getKontoNummer());
            });

            Random rnd = new Random();
            int nytKontonummer = 100+rnd.nextInt((kontoNumre.size()*2)+1);

            while (kontoNumre.contains(nytKontonummer)) {

                nytKontonummer =100+ rnd.nextInt((kontoNumre.size()*2)+1);
            }

            Konto nyKonto = new Konto(request.getParameter("navn"),request.getParameter("pwd1"),nytKontonummer,0,0,new BrugerListe(new ArrayList<>()),new TransaktionsListe(new ArrayList<>()));
            nyKonto.getBrugerListe().addToBrugerList(nytKontonummer);
            kontoMap.put(navn,nyKonto);

            session.setAttribute("konto",nyKonto);
            servletContext.setAttribute("kontiMap",kontoMap);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

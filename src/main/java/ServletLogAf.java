import DomianObjects.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ServletLogAf", value = "/ServletLogAf")
public class ServletLogAf extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        ServletContext servletContext = getServletContext();
        String opdaterProfil = request.getParameter("handling");
        String fejlBesked;



        if (opdaterProfil != null && opdaterProfil.equals("slet konto")) {
            Map<String, Konto> kontis = (Map<String, Konto>) getServletContext().getAttribute("kontiMap");
            String navn = (String) session.getAttribute("navn");

            kontis.remove(navn);

            servletContext.setAttribute("kontiMap",kontis);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        if (opdaterProfil != null && opdaterProfil.equals("opdater password")) {

            if (!request.getParameter("pwd1").equals(request.getParameter("pwd2"))) {
                fejlBesked = "De 2 password er ikke ens!";
                request.setAttribute("fejl",fejlBesked);

                request.getRequestDispatcher("WEB-INF/ProfilSetting.jsp").forward(request,response);
            }
            else {

                Map<String, Konto> kontis = (Map<String, Konto>) getServletContext().getAttribute("kontiMap");
                String navn = (String) session.getAttribute("navn");

                log("navn på kontohaverrrrrrrr " + navn);

                Konto old = kontis.get(navn);

                Konto nytPasswordKonto = new Konto(navn, request.getParameter("pwd1"), old.getKontoNummer(), old.getSaldo());
                kontis.put(navn, nytPasswordKonto);

                servletContext.setAttribute("kontiMap", kontis);

            }
        }

        request.getSession().invalidate();
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

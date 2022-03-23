import DomianObjects.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TransaktionServlet", value = "/TransaktionServlet")
public class TransaktionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String beløb = request.getParameter("beløb");
        log("beløbet er " + beløb);
        HttpSession session = request.getSession();

        int amount = 0;

        try {
            amount = Integer.parseInt(beløb);
        } catch (NumberFormatException e) {
            String fejl = "Husk beløbet skal være et tal";

            request.setAttribute("fejl", fejl);
            request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
        }


        Konto konto = (Konto) session.getAttribute("konto");
        konto.indsæt(amount);
        session.setAttribute("konto",konto);
        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String beløb = request.getParameter("beløb");
        log("beløbet er " + beløb);
        HttpSession session = request.getSession();

        int amount = 0;

        try {
            amount = Integer.parseInt(beløb);
        } catch (NumberFormatException e) {
            String fejl = "Husk beløbet skal være et tal";

            request.setAttribute("fejl", fejl);
            request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
        }


        Konto konto = (Konto) session.getAttribute("konto");
        konto.hæv(amount);
        session.setAttribute("konto",konto);
        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
    }
}

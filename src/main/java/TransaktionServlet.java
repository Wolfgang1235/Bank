import DomianObjects.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

@WebServlet(name = "TransaktionServlet", value = "/TransaktionServlet")
public class TransaktionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ServletContext servletContext = getServletContext();
        //Hent konti
        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("kontiMap");


        HttpSession session = request.getSession();
        String handling = request.getParameter("handling");

        Konto indsætPåKonto;

        Konto kontoLoggetPå = (Konto) session.getAttribute("konto");
        log ("konto i  brug: " + kontoLoggetPå.getKontoNummer());
        log("handling "+ handling);

        String navn = (String) session.getAttribute("navn");
        int indsætterNummer = kontoLoggetPå.getKontoNummer();

        session.setAttribute("kontoNummer",indsætterNummer);

        String beløb = request.getParameter("beløb");

        String indsætTilKonto = request.getParameter("kontonr");

        log("indsætterNummer: " + indsætterNummer+" indsætTilKonto: "+indsætTilKonto);


        if (indsætTilKonto !=null) {

            try {
                indsætTilKonto = request.getParameter("kontonr");

            } catch (NumberFormatException e) {
                String fejl = "Husk at kontonummer skal være et tal";
                request.setAttribute("fejl", fejl);
                request.getRequestDispatcher("WEB-INF/Transaktion.jsp").forward(request,response);
            }
        }



        int amount = 0;

        if (beløb != null) {
            try {
                amount = Integer.parseInt(beløb);
            } catch (NumberFormatException e) {
                String fejl = "Husk at beløbet skal være et tal";
                request.setAttribute("fejl", fejl);
                request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
            }
        }


        switch (handling) {
            case "indsæt":
                System.out.println("indsæt");

                if (beløb != null) {

                    for (Entry<String,Konto> entry : kontoMap.entrySet()) {

                        int find =  entry.getValue().getKontoNummer();
                        if (find == Integer.parseInt(indsætTilKonto)) {
                            log("find "+find + " indsætTilKonto: "+indsætTilKonto);
                            indsætPåKonto = entry.getValue();
                            indsætPåKonto.indsæt(amount,indsætterNummer);
                        }
                    }

                     session.setAttribute("konto", kontoLoggetPå);

                    request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
                }
                session.setAttribute("handling",handling);
                request.getRequestDispatcher("WEB-INF/Transaktion.jsp").forward(request,response);
                break;

            case "hæve":
                System.out.println("hæve");

                if (beløb !=null) {

                    for (Entry<String,Konto> entry : kontoMap.entrySet()) {

                        int find =  entry.getValue().getKontoNummer();
                        if (find == Integer.parseInt(indsætTilKonto)) {
                            indsætPåKonto = entry.getValue();
                            indsætPåKonto.hæv(amount,indsætterNummer);
                        }
                    }
                    //kontoLoggetPå.hæv(amount,indsætterNummer);
                    session.setAttribute("konto",kontoLoggetPå);
                    request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);

                }
                session.setAttribute("handling",handling);
                request.getRequestDispatcher("WEB-INF/Transaktion.jsp").forward(request,response);

                break;

            case "overførTilAndenKonto":
                System.out.println("overførTilAndenKonto");

                session.setAttribute("handling",handling);
                request.getRequestDispatcher("WEB-INF/Transaktion.jsp").forward(request,response);



                break;

            case "nedlægKonto":
                System.out.println("nedlægKonto");
                session.setAttribute("handling",handling);
                request.getRequestDispatcher("WEB-INF/ProfilSetting.jsp").forward(request,response);

                break;

            case "skiftPassword":
                System.out.println("skiftPassword");
                session.setAttribute("handling",handling);
                request.getRequestDispatcher("WEB-INF/ProfilSetting.jsp").forward(request,response);

                break;

            default:
                System.out.println("default");
                request.getRequestDispatcher("index.jsp").forward(request,response);


        }


//
//
//        String beløb = request.getParameter("beløb");
//        log("get Beløb er " + beløb);
//        HttpSession session = request.getSession();
//
//        int amount = 0;
//
//        try {
//            amount = Integer.parseInt(beløb);
//        } catch (NumberFormatException e) {
//            String fejl = "Husk at beløbet skal være et tal";
//            request.setAttribute("fejl", fejl);
//            request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
//           // request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
//        }
//
//
//        Konto konto = (Konto) session.getAttribute("konto");
//
//        konto.indsæt(amount);
//
//        session.setAttribute("konto", konto);
//        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log("request har " +  request.getParameter("submit"));
        String beløb = request.getParameter("beloeb1");
        log("Beløb er " + beløb);
        HttpSession session = request.getSession();
        String navn = (String) session.getAttribute("navn");
        int amount = 0;

        try {
            amount = Integer.parseInt(beløb);
        } catch (NumberFormatException e) {
            String fejl = "Husk at beløbet skal være et tal";
            request.setAttribute("fejl", fejl);
            request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);
        }


        Konto konto = (Konto) session.getAttribute("konto");

        //konto.hæv(amount,);

        session.setAttribute("konto", konto);
        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);

    }
}
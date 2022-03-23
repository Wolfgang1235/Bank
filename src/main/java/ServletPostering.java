import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletPostering", value = "/ServletPostering")
public class ServletPostering extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String beløb = request.getParameter("beløb");
        log("get Beløb er " + beløb);
        HttpSession session = request.getSession();

        int amount = 0;

        try {
            amount = Integer.parseInt(beløb);
        } catch (NumberFormatException e) {
            String fejl = "Husk at beløbet skal være et tal";
            request.setAttribute("fejl", fejl);
            request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int value = 0;
        int statusCode = HttpServletResponse.SC_BAD_REQUEST;

        String paramValue = request.getParameter("value");

        if (paramValue != null) {
            try {
                value = 2 * Integer.parseInt(paramValue);
                statusCode = HttpServletResponse.SC_OK;
            } catch (NumberFormatException ignored) {
            }
        }

        response.getWriter().println(value);

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(statusCode);
    }
}
package modul.servlet.main;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.*;
public class MainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        process(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        process(request, response);
    }
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Enumeration<String> parameterNames = request.getParameterNames();
        String operation = request.getParameter("operation");
        int a = Integer.parseInt(request.getParameter("one"));
        int b = Integer.parseInt(request.getParameter("two"));
        if(operation.equals("add")) {
            request.getSession().setAttribute("result", "a + b = " + Operation.add(a, b) + "\n");
        }
        else if (operation.equals("subtract")) {
            request.getSession().setAttribute("result", "a - b = " + Operation.substract(a, b) + "\n");
        }
        else if (operation.equals("multiply")) {
            request.getSession().setAttribute("result", "a * b = " + Operation.multiply(a, b) + "\n");
        }
        else if (operation.equals("divide")) {
            request.getSession().setAttribute("result", "a / b = " + Operation.divide(a, b) + "\n");
        }
        List<String> operations = (List<String>) request.getSession().getAttribute("operations");
        if (operations == null) {
            operations = new ArrayList<String>();
        }
        operations.add((String) request.getSession().getAttribute("result"));
        request.getSession().setAttribute("operations", operations);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp");
        requestDispatcher.forward(request, response);
    }
}

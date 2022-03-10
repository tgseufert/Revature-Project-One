package frontend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/sandbox")
public class ServletSandbox extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out =response.getWriter();
        out.println("hi");
        String input =request.getParameter("saved recipes");
        out.println(input.toString());
    }

}

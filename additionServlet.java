import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class additionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int n1 = Integer.parseInt(request.getParameter("first"));
        int n2 = Integer.parseInt(request.getParameter("second"));
        int s = n1+n2;
        out.println("<html> <body> <h1> Sum is "+s+"</h1></body></html>");
        // request.setAttribute("sum","ssss");
    }

}
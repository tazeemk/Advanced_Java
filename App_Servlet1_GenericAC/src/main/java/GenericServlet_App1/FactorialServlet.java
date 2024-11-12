package GenericServlet_App1;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/fa")
public class FactorialServlet extends GenericServlet
{
public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
{
	int x=Integer.parseInt(req.getParameter("v1"));
	int y =Integer.parseInt(req.getParameter("v2"));
	int z =x+y;
	z =(z-1)*z+(z-2)*z+(z-3)*z+(z-4)*z;
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	pw.print("Factorial is :"+z+"<br>");
	RequestDispatcher rd = req.getRequestDispatcher("choice.html");
	rd.include(req, res);
}
}

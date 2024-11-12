package GenericServlet_App1;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/mu")
public class MultiplicationServlet extends GenericServlet 
{
public void service(ServletRequest re,ServletResponse res) throws ServletException,IOException
{
	int x = Integer.parseInt(re.getParameter("v1"));
	int y =Integer.parseInt(re.getParameter("v2"));
	int z =x*y;
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	pw.print("Multiplication "+z+"<br>");
	RequestDispatcher r = re.getRequestDispatcher("choice.html");
	r.include(re, res);
	}
	
}

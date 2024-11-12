package GenericServlet_App1;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/ad")
public class AddServlet extends GenericServlet 
{
public void service(ServletRequest re ,ServletResponse res)throws ServletException,IOException
{
	int x =Integer.parseInt(re.getParameter("v1"));
	int y =Integer.parseInt(re.getParameter("v2"));
	int z =(int)x+y;
	   PrintWriter ps=res.getWriter();
	   res.setContentType("text/html");
	   ps.print("Additon "+z+"<br>");
	   RequestDispatcher rd = re.getRequestDispatcher("choice.html");
	   rd.include(re, res);
}
}

package GenericServlet_App1;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/av")
public class AverageServlet extends GenericServlet 
{

	public void service(ServletRequest re,ServletResponse rs)throws ServletException,IOException
	{
		
		int x =Integer.parseInt(re.getParameter("v1"));
		int y =Integer.parseInt(re.getParameter("v2"));
		int z=(int)(x+y)/2;
	PrintWriter ps	=rs.getWriter();
	rs.setContentType("text/html");
	ps.print("Average :"+z+"<br>");
	
	RequestDispatcher rd = re.getRequestDispatcher("choice.html");
	rd.include(re, rs);
	
	}
}

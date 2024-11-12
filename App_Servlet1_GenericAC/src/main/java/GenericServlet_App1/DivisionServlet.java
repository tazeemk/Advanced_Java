package GenericServlet_App1;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/di")
public class DivisionServlet extends GenericServlet
{
  public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
  {
	  try {
		  int x = Integer.parseInt(req.getParameter("v1"));
		  int y =Integer.parseInt(req.getParameter("v2"));
		  int z =(x/y);
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	pw.print("Division :"+z+"<br>");
	RequestDispatcher rd = req.getRequestDispatcher("choice.html");
	rd.include(req, res);
		  
	  }catch(Exception e) 
	  {
		System.out.println("Divisor Cannot be Zero :");
		RequestDispatcher rd1 = req.getRequestDispatcher("choice.html");
		rd1.include(req, res);
	  }
  }
}

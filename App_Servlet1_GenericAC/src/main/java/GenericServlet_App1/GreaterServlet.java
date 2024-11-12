package GenericServlet_App1;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/gr")
public class GreaterServlet extends GenericServlet
{

	public void service(ServletRequest req,ServletResponse res ) throws ServletException,IOException
	{
		int x=Integer.parseInt(req.getParameter("v1"));
		int y=Integer.parseInt(req.getParameter("v2"));
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		if(x>y)
		{
			pw.print("Greatest is "+x+"<br>");
		}else {
			pw.print("Greatest is "+y+"<br>");
		}
		RequestDispatcher rd = req.getRequestDispatcher("choice.html");
		rd.include(req, res);
	}
}

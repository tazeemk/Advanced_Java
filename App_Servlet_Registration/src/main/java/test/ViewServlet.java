package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/view")
public class ViewServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req ,HttpServletResponse re )throws ServletException,IOException
	{
		Cookie c[]=req.getCookies();
		if(c==null) {
			req.setAttribute("msg", "Ssssion Expired :<br>");
			req.getRequestDispatcher("msg.jsp").forward(req, re);
		}else {
			
			String Fn =c[0].getValue();
			req.setAttribute("fname", Fn);
			req.getRequestDispatcher("ViewUser.jsp").forward(req, re);
			
		}
		
	}
}

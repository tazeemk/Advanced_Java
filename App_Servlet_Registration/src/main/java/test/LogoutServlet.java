package test;
import java.io.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{

	protected void doGet(HttpServletRequest req,HttpServletResponse res )throws ServletException,IOException
	{
		Cookie c[]=req.getCookies();
		if(c==null) {
			
			req.setAttribute("msg", "Session Experied :");
			req.getRequestDispatcher("msg.jsp");
		}else {
			ServletContext sc = req.getServletContext();
			sc.removeAttribute("ubean");
			c[0].setMaxAge(0);
			res.addCookie(c[0]);
			req.setAttribute("msg", "Logout Successfully ...");
		}
		req.getRequestDispatcher("msg.jsp").forward(req, res);;
				
	}

}

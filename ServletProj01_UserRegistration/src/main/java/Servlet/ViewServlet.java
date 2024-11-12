package Servlet;
import java.io.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
@WebServlet("/view")
public class ViewServlet extends HttpServlet 
{
protected void doGet(HttpServletRequest req,HttpServletResponse res ) throws ServletException,IOException
{
	Cookie c[]=req.getCookies();
	if(c==null)
	{
	          req.setAttribute("msg", "Session Expired :");
	          req.getRequestDispatcher("login.jsp").forward(req, res);
	}else {
		String name =c[0].getValue();
		req.setAttribute("name", name);
		req.getRequestDispatcher("view.jsp").forward(req, res);
	}
	
}
}

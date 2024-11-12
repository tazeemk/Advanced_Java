package Servlet;

import jakarta.servlet.http.HttpServlet;
import java.io.*;
import DAO.LoginDAO;
import Ubean.UserBean;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@WebServlet("/log")
public class LoginServlet extends HttpServlet
{
	
protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException
{
	long pword =Long.parseLong(req.getParameter("rnumber"));
	UserBean ub = new LoginDAO().login( pword);
	
	if(ub==null) {
		req.setAttribute("msg", ub);
		
	}else{
		
		Cookie c =new Cookie("name", ub.getName());//creating Cookie with name  
		res.addCookie(c);//sending Cookie through response to web 
		ServletContext sc= req.getServletContext();
		sc.setAttribute("ubean",ub);
		req.setAttribute("msg", "Login successfully.....");
		req.getRequestDispatcher("Success.jsp").forward(req, res);
		
		
	}
	
}       
}

package test;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import java.io.*;
@WebServlet("/log")
public class LoginServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
String uN= req.getParameter("uname");
	String pW=req.getParameter("pword");
	
    UserBean ub=new  LoginDAO().login(uN, pW);
    
    if(ub==null) {
    	req.setAttribute("ms", "Invalid Data");
    	RequestDispatcher re = req.getRequestDispatcher("msg.jsp");
    	re.forward(req, res);
    }else {
    	ServletContext slc = req.getServletContext();
    	slc.setAttribute("ubean", ub);
    	Cookie ck = new Cookie("fname", ub.getFname());
    	res.addCookie(ck);
    	RequestDispatcher rd = req.getRequestDispatcher("logSuccess.jsp");
    	rd.forward(req, res);
    	
    }
	}
	
}

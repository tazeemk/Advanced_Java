package test;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet
{
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	UserBean ub = new UserBean();
	ub.setUname(req.getParameter("uname"));
	ub.setPword(req.getParameter("pword"));
	ub.setFname(req.getParameter("fname"));
	ub.setLname(req.getParameter("lname"));
	ub.setAdd(req.getParameter("addr"));
	ub.setMid(req.getParameter("mid"));
	ub.setPhno(Long.parseLong(req.getParameter("phno")));
	
	int k= new RegisterDAO().insert(ub);
	if(k>0){
		req.setAttribute("msg", "User Registration Successfully...<br>");
		RequestDispatcher rd = req.getRequestDispatcher("Success.jsp");
		rd.forward(req, res);
	}else {
		
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	pw.print("something wrong chehck");
	}
}
}

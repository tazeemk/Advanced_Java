package Servlet;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import  Ubean.UserBean;
import DAO.DAORegist;
@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet
{
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
	 UserBean ub = new UserBean();
	 ub.setRoll_no(Long.parseLong(req.getParameter("rnumber")));
	 ub.setName(req.getParameter("name"));
	 ub.setFname(req.getParameter("fname"));
	 ub.setDept(req.getParameter("dept"));
	 ub.setAddr(req.getParameter("addr"));
	 
	 int k= new DAORegist().register(ub);
	 if(k>0){
		 
		 req.setAttribute("msg", "Registation Successfully.....");
		 req.getRequestDispatcher("RegSuccess.jsp").forward(req, res);
	 }
	 
 }
}

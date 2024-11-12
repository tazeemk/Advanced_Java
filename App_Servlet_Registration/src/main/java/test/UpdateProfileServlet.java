package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet
{
   @Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
	   Cookie c[]=req.getCookies();
	   if(c==null) {
		   
		   req.setAttribute("msg", "Session Expired :");
		   req.getRequestDispatcher("msg.jsp").forward(req, res);
	   }else 
	   {
		String Fn=c[0].getValue();
		ServletContext sc = req.getServletContext();
		UserBean ub =(UserBean)sc.getAttribute("ubean");
		ub.setAdd(req.getParameter("uname"));
		ub.setMid(req.getParameter("mid"));
		ub.setPhno(Long.parseLong(req.getParameter("phno")));
		
		
		   int k= new UpdateProfileDAO().update(ub);
		   if(k>0){
			   
			   req.setAttribute("msg", "Profile Updated Successfully...");
			   req.setAttribute("fname", Fn);
			   req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
			   
		   }
		   
	   }
	   
	}
	
}

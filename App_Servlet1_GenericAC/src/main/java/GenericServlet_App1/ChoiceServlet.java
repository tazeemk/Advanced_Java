package GenericServlet_App1;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/choice")
public class ChoiceServlet extends GenericServlet 
{
public void service(ServletRequest re,ServletResponse res)throws ServletException,IOException
{
	String s1 =re.getParameter("s1");
	if(s1.equals("Avg")) 
	{
		RequestDispatcher rd = re.getRequestDispatcher("av");
		rd.forward(re, res);
	}	
	else if (s1.equals("Add"))
	{

		RequestDispatcher rs = re.getRequestDispatcher("ad");
		rs.forward(re, res);
	}else if(s1.equals("mul")) 
	{
		RequestDispatcher rd1 = re.getRequestDispatcher("mu");
		rd1.forward(re, res);
	}else if(s1.equals("div")) 
	{
		RequestDispatcher rd2 = re.getRequestDispatcher("di");
		rd2.forward(re, res);
	}else if(s1.equals("sub"))
	{
		RequestDispatcher rd3 = re.getRequestDispatcher("su");
		rd3.forward(re, res);
		
	}else if(s1.equals("Greater")) 
	{
	RequestDispatcher rd4 = re.getRequestDispatcher("gr");
	rd4.forward(re, res);
		
	}else if (s1.equals("Smaller")) 
	{
	RequestDispatcher rd5 = re.getRequestDispatcher("sm");
	rd5.forward(re, res);
		
	}else if(s1.equals("Factorial"))
	{
		RequestDispatcher rd6 = re.getRequestDispatcher("fa");
		rd6.forward(re, res);
	}
		
	
	
}
	
}

package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/dis")
public class Display extends GenericServlet
{
public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
{
RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
rd.forward(req, res);
}
}

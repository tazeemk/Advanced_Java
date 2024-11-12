package DAO;
import java.sql.*;
import Servlet.LoginServlet;
import DB.DBConnection;
import Ubean.UserBean;
public class LoginDAO 
{
public   UserBean ub=null;

public UserBean login(long pword)
{
try{
	Connection con =DBConnection.getcon();
	PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENT WHERE ROLL_NO=?");
	ps.setLong(1, pword);
	
	ResultSet rs = ps.executeQuery();
	if(rs.next()) {
		ub=new UserBean();
		ub.setRoll_no(rs.getLong(1));
		ub.setName(rs.getNString(2));
		ub.setFname(rs.getString(3));
		ub.setDept(rs.getString(4));
		ub.setAddr(rs.getString(5));
		
		
	}
	
}catch(Exception e) {
	e.printStackTrace();
}
	return ub;
}
}

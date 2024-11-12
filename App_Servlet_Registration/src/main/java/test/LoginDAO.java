package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO 
{
public  UserBean ub =null;

public UserBean login(String uN,String pW) 
{
	try {
		
 Connection con = DBConnection.getCon();
 PreparedStatement ps = con.prepareStatement("SELECT * FROM USERREG WHERE UNAME=? AND PWORD =?");
 ps.setString(1, uN);
 ps.setString(2, pW);
	
ResultSet re = ps.executeQuery();
if(re.next()) 
{
 ub= new UserBean();
 ub.setUname(re.getString(1));
 ub.setPword(re.getString(2));
 ub.setFname(re.getString(3));
 ub.setLname(re.getString(4));
 ub.setAdd(re.getString(5));
 ub.setMid(re.getString(6));
 ub.setPhno(re.getLong(7));
	
}
 
 
	}catch(Exception e) {
		e.printStackTrace();
	}
	
 
 return ub;
}
	
	
}

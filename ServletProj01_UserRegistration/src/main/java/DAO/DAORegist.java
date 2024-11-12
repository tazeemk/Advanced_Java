package DAO;
import java.sql.*;
import Ubean.UserBean;
import DB.DBConnection;
public class DAORegist 
{
	int k=0;
public int register(UserBean ub){
	try {
		Connection con = DBConnection.getcon();
		PreparedStatement ps =con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?)");
		ps.setLong(1, ub.getRoll_no());
		ps.setString(2, ub.getName());
		ps.setString(3, ub.getFname());
		ps.setString(4, ub.getDept());
		ps.setString(5, ub.getAddr());
		k=ps.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return k;
	
}
	
}

package DB;
import java.sql.*;

public class DBConnection 
{
private	DBConnection(){
		
	}
static Connection con=null;
static {
	try {
		Class.forName(DBAttr.driver);
		 con = DriverManager.getConnection(DBAttr.Url,DBAttr.uname,DBAttr.pword);
		
	}catch(Exception e) 
	{
	e.printStackTrace();	

	
}
}
public static Connection getcon(){
	return con;
       }

}

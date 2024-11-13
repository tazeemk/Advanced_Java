package JDBC_App_MetaData;

import java.sql.*;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try(sc;){
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
            ,"SYSTEM","TIGER");
            System.out.println("******************DatabaseMetaData***********************");
            DatabaseMetaData dmd = con.getMetaData();
            System.out.println("DB Version :"+dmd.getDatabaseProductVersion());
            System.out.println("UserName :"+dmd.getUserName());
            System.out.println("DB Product Name :"+dmd.getDatabaseProductName());
            System.out.println("**************ParameterMetaData*****************");
            PreparedStatement ps = con.prepareStatement("INSERT INTO BOOKDETAIL VALUES(?,?,?,?,?)");
            ParameterMetaData pmd = ps.getParameterMetaData();
            System.out.println(" "+pmd.getParameterCount());
            System.out.println("*****************ResultSetMetaData******************");
            PreparedStatement ps2 = con.prepareStatement("SELECT BCODE,BNAME,PRICE FROM BOOKDETAIL");
            ResultSet rs = ps2.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Column count :"+rsmd.getColumnCount());
            System.out.println("Column Name:"+rsmd.getColumnName(1));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

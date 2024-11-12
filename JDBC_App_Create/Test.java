package JDBC_App_Create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args)throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
        ,"SYSTEM","TIGER");
        Statement stm =con.createStatement();
        try(stm;con;sc;){
            System.out.println("PLEASE PERFORM THE FOLLOWING OPERATION (CREATE,INSERT ,UPDATE,DELETE)");
            String msg = sc.nextLine();
            int k = stm.executeUpdate(msg);
            if (k>=0)
            {
                System.out.println("Value of k "+k);
                System.out.println("Operation Successfully....");
            }else {
                System.out.println("PLEASE ENTER VALID QUERY :");
            }
        }catch (Exception e)
        {
        e.printStackTrace();
        }
    }
}

package JDBC_CallableStatmen;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;
import java.util.Scanner;

public class IN
{
    public static void main(String[] args)throws Exception
    {


        Scanner sc = new Scanner(System.in);
        try {
       Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
            ,"SYSTEM","TIGER");
            CallableStatement cs = con.prepareCall("{CALL CREATEACCOUNT(?,?,?,?,?,?,?,?,?)}");
            System.out.println("PLEASE ENTER ACCOUNT NUMBER :");
            int accno = Integer.parseInt(sc.nextLine());
            System.out.println("PLEASE ENTER YOUR NAME :");
             String name = sc.nextLine();
            System.out.println("PLEASE ENTER YOUR BALANCE ");
            int bal = Integer.parseInt(sc.nextLine());
            System.out.println("PLEASE ENTER ACCOUNT TYPE ");
            String atype = sc.nextLine();
            System.out.println("PLEASE ENTER YOUR CITY :");
            String cty = sc.nextLine();
            System.out.println("PLEASE ENTER YOUR STATE ");
            String st = sc.nextLine();
            System.out.println("PLEASE ENETER YOUR PIN :");
            int pn = Integer.parseInt(sc.nextLine());
            System.out.println("PLEASE ENTER YOUR EMAIL ID :");
            String em = sc.nextLine();
            System.out.println("PLEASE ENTER YOUR PHONE NO :");
            int ph = sc.nextInt();
       cs.setInt(1,accno);
       cs.setString(2,name);
       cs.setInt(3,bal);
       cs.setString(4,atype);
       cs.setString(5,cty);
       cs.setString(6,st);
       cs.setInt(7,pn);
       cs.setString(8,em);
       cs.setInt(9,ph);
       cs.execute();
            System.out.println("details inserted successfully......");
   con.close();
   sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

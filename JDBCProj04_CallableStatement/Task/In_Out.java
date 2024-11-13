package JDBC_CallableStatmen.Task;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class In_Out
{
     int bsal;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "SYSTEM","TIGER");
            CallableStatement cs = con.prepareCall("{CALL EmpDetail(?,?,?,?,?,?,?,?,?,?,?,?)}");
            System.out.println(" Enter The Employee ID:");
            int eid = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the employee Name :");
            String  name = sc.nextLine();
            System.out.println("Enter Employee Degigenation :");
            String eds = sc.nextLine();
            System.out.println("Enter city name :");
            String cty = sc.nextLine();
            System.out.println("Enter State Name :");
            String st = sc.nextLine();
            System.out.println("Enter pincode :");
            int pin = Integer.parseInt(sc.nextLine());
            System.out.println("Enter Your Email ID:");
            String email = sc.nextLine();
            System.out.println("Enter your phone number :");
            int no = sc.nextInt();
            System.out.println("Enter your basic salary :");
            int bsal = sc.nextInt();
            System.out.println("Enter your hra :");
            int hra = sc.nextInt();
            hra = (93/100)*bsal;
            System.out.println("Enter your DA :");
            int da = sc.nextInt();
            System.out.println("Enter your total salary :");
            int tsal = sc.nextInt();

            cs.setInt(1,eid);
            cs.setString(2,name);
            cs.setString(3,eds);
            cs.setString(4,cty);
            cs.setString(5,st);
            cs.setInt(6,pin);
            cs.setString(7,email);
            cs.setInt(8,no);
            cs.setInt(9,bsal);
            cs.setInt(10,hra);
            cs.setInt(11,da);
            cs.setInt(12,tsal);
            cs.execute();
            System.out.println("Record uploaded successfully.....");

        }catch (Exception e){

        }
    }
}

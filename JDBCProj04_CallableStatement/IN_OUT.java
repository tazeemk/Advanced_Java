package JDBC_CallableStatmen;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class IN_OUT {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
            ,"SYSTEM","TIGER");
            CallableStatement cs = con.prepareCall("{CALL RETRIEVEDETAIL(?,?,?,?,?,?,?,?,?)}");
            System.out.println("please enter accountNumber :");
            int accn = sc.nextInt();
            cs.setInt(1,accn);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3,Types.INTEGER);
            cs.registerOutParameter(4,Types.VARCHAR);
            cs.registerOutParameter(5,Types.VARCHAR);
            cs.registerOutParameter(6,Types.VARCHAR);
            cs.registerOutParameter(7,Types.INTEGER);
            cs.registerOutParameter(8,Types.VARCHAR);
            cs.registerOutParameter(9,Types.INTEGER);
            cs.execute();
            System.out.println("AccNo ::"+accn);
            System.out.println("Name ::"+cs.getString(2));
            System.out.println("Balance ::"+cs.getInt(3));
            System.out.println("AccType ::"+cs.getString(4));
            System.out.println("City ::"+cs.getString(5));
            System.out.println("State ::"+cs.getString(6));
            System.out.println(" Pincode ::"+cs.getInt(7));
            System.out.println("Email ID ::"+cs.getString(8));
            System.out.println("Phone Number ::"+cs.getInt(9));


            System.out.println("Data Retrieved Successfully..........");
          con.close();
          cs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
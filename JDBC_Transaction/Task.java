package JDBC_Transaction;

import java.sql.*;
import java.util.Collection;
import java.util.Scanner;

public class Task
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (sc;){
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
            ,"MYDBA","TIGER");
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(" SELECT * FROM BANK55 WHERE ACCNO =?");
            PreparedStatement ps1 = con.prepareStatement("UPDATE BANK55 SET BALANCE = BALANCE+? WHERE ACCNO =?");
            System.out.println("ENTER BANK HOME ACCOUNT NUMBER : ");
            int hac = sc.nextInt();
            ps.setInt(1,hac);
            ResultSet re = ps.executeQuery();
            Savepoint sp = con.setSavepoint();
            if (re.next()){
                int bal= re.getInt(3);
                System.out.println("ENTER BENEFICIAL ACCOUNT NUMBER :");
                int acc = sc.nextInt();
                ResultSet re1 = ps.executeQuery();
                //re.close();
                if(re1.next()){
                    System.out.println("Enter amount to transfer :");
                    int amt = sc.nextInt();
                    if (amt<=bal)
                    {
                     ps1.setInt(1,-amt);
                     ps1.setInt(2,hac);
                       int x=ps1.executeUpdate();
                       ps1.setInt(1,amt);
                       ps1.setInt(2,acc);
               int y = ps1.executeUpdate();
                       if (x==1 && y==1){
                           con.commit();
                           System.out.println("Amount Transferred Successfully...");
                       }else {
                           con.rollback(sp);
                       }
                    }
                }else {
                    System.out.println("INVALID ACCOUNT NUMBER :");
                }
            }else {
                System.out.println("Invalid Account Number ::");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

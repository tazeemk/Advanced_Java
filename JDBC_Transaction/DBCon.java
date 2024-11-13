package JDBC_Transaction;

import oracle.jdbc.proxy.annotation.Pre;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

public class DBCon
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try (sc;)
        {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
                    ,"MYDBA","TIGER");
            System.out.println(con.getAutoCommit());
            con.setAutoCommit(false);
            System.out.println(con.getAutoCommit());

            PreparedStatement ps = con.prepareStatement(" SELECT * FROM BANK55 WHERE ACCNO=?");
            PreparedStatement ps1 = con.prepareStatement("UPDATE BANK55 SET BALANCE = BALANCE +? WHERE ACCNO=?");
            System.out.println("ENTER YOUR HOME ACCOUNT NUMBER :");
            int hacno = sc.nextInt();
            ps.setInt(1,hacno);
            ResultSet re = ps.executeQuery();
            if (re.next())
            {
                int bl  = re.getInt(3);
                System.out.println("ENTER BENEFICIAL  ACCOUNT NUMBER ");
                int bacno = sc.nextInt();
                ps.setInt(1,bacno);
                Savepoint sp =con.setSavepoint();
                ResultSet re1 =ps.executeQuery();
                if (re1.next())
                {
                    System.out.println("Enter The Amount to Transfer ::");
                    int amt=sc.nextInt();
                      if(amt<=bl)
                      {
                          //Subtracting amount from HomeAccount
                          ps1.setInt(1,-amt);
                          ps1.setInt(2,hacno);
                          int m= ps1.executeUpdate();
                          //Adding amount to Beneficial Account
                          ps1.setInt(1,amt);
                          ps1.setInt(2,bacno);
                          int n = ps1.executeUpdate();
                          if (m==1&&n==1)
                          {
                                con.commit();
                              System.out.println("Amount Transferred Successfully..");
                          }else {
                              con.rollback(sp);
                          }

                      }else {
                          System.out.println("Insufficient Fund...");
                      }

                }else {
                    System.out.println("Invalid Account Number :");
                }

            }else {
                System.out.println("invalid account number :");
            }

        }catch (Exception e)
        {

        }
    }
}

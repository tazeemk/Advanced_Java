package jdbc_preparedStatment;

import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test
{
   //static int BCODE;
    public static void main(String[] args)
    //Performing insert ,update ,delete ,select by using preparedStatement
    {
        try {
            Scanner sc = new Scanner(System.in);
            //Loading Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Creating connection b/w DB and Connection Interface object
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","TIGER");
  //Here We are Creating
            PreparedStatement ps = con.prepareStatement("insert into BOOKDETAIL values(?,?,?,?,?)");
            PreparedStatement ps1 = con.prepareStatement("select * from BOOKDETAIL ");
            PreparedStatement ps2 = con.prepareStatement("SELECT * FROM BOOKDETAIL WHERE BCODE =?");
            PreparedStatement ps3 =con.prepareStatement("Update BOOKDETAIL Set Price= ?,QUANTITY = QUANTITY+? Where BCODE=?");
            PreparedStatement ps4 = con.prepareStatement("DELETE FROM BOOKDETAIL WHERE BCODE =?");
            while (true)
            {
                System.out.println("\n**********BOOK DETAILS***********");
                System.out.println("1.AddBookDetails ");
                System.out.println("2.ViewAllBookDetails ");
                System.out.println("3.ViewBookDetailsByCode ");
                System.out.println("4.UpdateBookDetailsByCode ");
                System.out.println("5.DeleteBookDetailsByCode ");
                System.out.println("6.Exit ");
                int n = sc.nextInt();
                 switch (n)
                 {
                     case 1:
                         System.out.println("Enter Book Code ::");
                         int bc=sc.nextInt();
                                 sc.nextLine();
                         System.out.println("Enter Book Name :");
                         String Bk = sc.nextLine();
                         System.out.println("Enter BooK Author :");
                         String BA = sc.nextLine();
                         System.out.println("Enter Book Price :");
                         int Price = sc.nextInt();
                         System.out.println("Enter Book Quantity :");
                         int Quantity = sc.nextInt();
                         ps.setInt(1,bc);
                         ps.setString(2,Bk);
                         ps.setString(3,BA);
                         ps.setInt(4,Price);
                         ps.setInt(5,Quantity);
                         int k = ps.executeUpdate();
                         if (k>0)
                         System.out.println("Record Inserted Successfully ......");
                         break;
                     case 2:
                         System.out.println("\nBOOK DETAILS ARE ::");
                         ResultSet re = ps1.executeQuery();

                         while (re.next()){

                             System.out.println(re.getInt(1)+" "+re.getString(2)+" "+re.getString(3)+
                                     " "+re.getInt(4)+" "+re.getInt(5) );
                         }
                         break;
                     case 3:
                         System.out.println("\nPlease Enter BookCode ::");
                          int BCODE = sc.nextInt();
                          ps2.setInt(1,BCODE);
                         ResultSet r = ps2.executeQuery();

                         if (r.next())
                         {
                             System.out.println(r.getLong(1)+" "+r.getString(2)+" "+r.getString(3)
                             +" "+r.getInt(4)+" "+r.getLong(5)+"\n");
                         }
                         else{
                             System.out.println("Invalid Data......");
                         }


                         break;
                     case 4:
                      //   System.out.println("CHOICE COLUMN TO UPDATE ::");

                         System.out.println("ENTER NEW PRICE OF BOOK ::");
                       int Nprice =sc.nextInt();
                                   sc.nextLine();
                         System.out.println("ADD NEW QUANTITY IN EXISTING QUANTITY ::");
                         int QTY = sc.nextInt();

                         System.out.println("PLEASE ENTER  BCODE TO UPDATE ::");
                         int Bcode = sc.nextInt();

                                 ps3.setInt(1,Nprice);
                                 ps3.setInt(2,QTY);
                                 ps3.setInt(3,Bcode);
                                 int k1 = ps3.executeUpdate();
                                 if (k1>0){
                                     System.out.println("RECORD UPDATED SUCCESSFULLY........");
                                 }else {
                                     System.out.println("INVALID ENTRY......");
                                 }
                         break;
                     case 5:
                         System.out.println("ENTER THE BOOK CODE TO DELETE FROM DB:");
                         int Bcde =sc.nextInt();
                         ps4.setInt(1,Bcde);
                         int x=ps4.executeUpdate();
                         if (x>0){
                             System.out.println("RECORD DELETED SUCCESSFULLY...");
                         }
                         else {
                             System.out.println("SORRY NO RECORD FOUND.....");
                         }
                         break;
                     case 6:
                         System.out.println("Program Stopped ");
                         System.exit(0);
                         break;
                     default:
                         break;

                 }

            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

        }
    }
}

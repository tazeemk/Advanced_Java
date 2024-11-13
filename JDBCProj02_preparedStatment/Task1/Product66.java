package jdbc_preparedStatment.Task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Product66 {
    //PERFORMINING INSERT,UPDATE,DELETE,SELECT ON TABLE PRODUCT66 PRESENT IN DB
    // BY USING JDBC PREPAREDSTATEMENT COLLECTION
    public static void main(String[] args) {

        try {
       //LOADING DRIVER
            Scanner sc = new Scanner(System.in);
       Class.forName("oracle.jdbc.driver.OracleDriver");
       //CONNECTING DATABASE THROUGH CONNECTION INTERFACE
            Connection co = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","TIGER");
            //PREPARING PREPAREDSTATEMENT TO RUN AUR DB OPERATION
            PreparedStatement ps = co.prepareStatement("INSERT INTO PRODUCT66 VALUES(?,?,?,?,?)");//in PS we can write our insert,update,delete query in preparedstatment
            PreparedStatement ps1 = co.prepareStatement("SELECT * FROM PRODUCT66");
            PreparedStatement ps2 = co.prepareStatement("SELECT * FROM PRODUCT66 WHERE CODE=? ");
           PreparedStatement ps3 =co.prepareStatement("UPDATE PRODUCT66 SET FOUNDER = ? WHERE CODE=?");
           PreparedStatement ps4 =co.prepareStatement("DELETE FROM PRODUCT66 WHERE CODE=?");
            while (true)
            {
                System.out.println("*****************PRODUCT66 DETAILS********************");
                System.out.println("1.AddProduct ::");
                System.out.println("2.ViewAllProduct ::");
                System.out.println("3.ViewProductByCode ::");
                System.out.println("4.UpdateProductByCode ");
                System.out.println("5.DeleteProductByCode ");
                System.out.println("6.Exit ");
                int no = sc.nextInt();
                switch (no)
                {
                    case 1:
                        System.out.println("=================Insertion=============\n ");
                        System.out.println("ENETR PRODUCT CODE ::");
                         int pcode = sc.nextInt();
                                     sc.nextLine();
                        System.out.println("ENTER PRODUCT NAME ::");
                        String pname = sc.nextLine();
                        System.out.println("ENTER PRICE OF THE PRODUCT ::");
                        double pprice = sc.nextDouble();
                        System.out.println("ENTER QUANTITY OF PRODUCT ::");
                        int pqty = sc.nextInt();
                                   sc.nextLine();
                        System.out.println("ENTER FOUNDER OF THE PRODUCT ::");
                        String Fname = sc.nextLine();
                        ps.setInt(1,pcode);
                        ps.setString(2,pname);
                        ps.setDouble(3,pprice);
                        ps.setInt(4,pqty);
                        ps.setString(5,Fname);
                        int x = ps.executeUpdate();
                        if (x>0){
                            System.out.println("RECORD INSERTED SUCCESSFULLY.....");
                        }else {
                            System.out.println("ENTER VALID DATA....");
                        }

                        break;
                    case 2:
                        System.out.println("=============VIEW YOUR DATA==============\n ");
                        ResultSet re = ps1.executeQuery();
                        while (re.next()){
                            System.out.println(re.getInt(1)+" "+re.getString(2)+" "+re.getLong(3)+" "+re.getInt(4)
                            +" "+re.getString(5));
                        }
                        break;
                    case 3:
                        System.out.println("=============RETRIVING SPECIFIC DATA==============\n");
                        System.out.println("PLEASE ENTER PRODUCT CODE TO SEE DETAILS::");
                        int pcd = sc.nextInt();
                        ps2.setInt(1,pcd);
                        ResultSet rs= ps2.executeQuery();
                        if (rs.next()){
                            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getLong(3)
                            +" "+rs.getInt(4)+" "+rs.getString(5));
                        }
                        else {
                            System.out.println("Invalid Product code ::");
                        }
                        break;
                    case 4:
                        System.out.println("===============UPDATING DATA================\n");
                        System.out.println("UPDATE FOUNDER NAME WITH CODE WISE ::\n");
                        System.out.println("PLEASE ENTER THE NAME TO UPDATE ::");
                        String fo = sc.next();
                        System.out.println("PLEASE ENTER THE PRODUCT CODE TO UPDATE THE NAME ");
                        int cd = sc.nextInt();
                        ps3.setString(1,fo);
                        ps3.setInt(2,cd);
                        int y = ps3.executeUpdate();
                        if (y>0){
                            System.out.println("RECORD UPDATED SUCCESSFULLY......");
                        }else {
                            System.out.println("PLEASE ENTER VALID DATA ...");
                        }

                        break;
                    case 5:
                        System.out.println("=================DELETING DATA================== \n");
                        System.out.println("PLEASE ENTER THE CODE TO DELETE THE RECORD FROM DB :");
                        int cdm = sc.nextInt();
                        ps4.setInt(1,cdm);
                        int n = ps4.executeUpdate();
                        if (n>0){
                            System.out.println("RECORD DELETE SUCCESSFULLY........");
                        }else {
                            System.out.println("PLEASE ENTER CORRECT CODE::");
                        }
                        break;
                    case 6:
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
    }
}
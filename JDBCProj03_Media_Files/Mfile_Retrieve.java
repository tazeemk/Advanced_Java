package JDBC_Media_Files;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Scanner;

public class Mfile_Retrieve
{
    public static void main(String[] args)throws Exception
    {
        Scanner sc = new Scanner(System.in);
        try(sc;) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
            ,"SYSTEM","TIGER");
            Statement stm = con.createStatement();
            System.out.println("Please Enter id to retrieve Mfile :");
            String I = sc.nextLine();
            ResultSet re = stm.executeQuery("Select * from STREAMTAB WHERE ID='"+I+"' ");
             if (re.next()){
                 Blob b = re.getBlob(2);
                 byte by[]=b.getBytes(1,(int)b.length());
                 System.out.println("Please enter path to store your file ");
                 FileOutputStream fos = new FileOutputStream(sc.nextLine());
                 fos.write(by);
                 System.out.println("File retrived Successfully.....");
             }

        }
    }
}

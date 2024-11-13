package JDBC_Media_Files;

import oracle.jdbc.proxy.annotation.Pre;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Scanner;

public class M_file_IN_O
{
    public static void main(String[] args)throws Exception
    {
        Scanner sc = new Scanner(System.in);
     /*  try (sc;){
            System.out.println("ADDING AND RETRIEVING VIDEO FROM DB::");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
            ,"SYSTEM","TIGER");
            PreparedStatement ps = con.prepareStatement("INSERT INTO STREAMTAB VALUES(?,?)");
            System.out.println("PLEASE ENTER ID :");
            String id = sc.nextLine();
            System.out.println("PLEASE ENETR FILE PATH :");
            File f = new File(sc.nextLine());
            ps.setString(1,id);
            if (f.exists()){
                FileInputStream fis = new FileInputStream(f);
            ps.setBinaryStream(2,fis,f.length());
                int x= ps.executeUpdate();
                if (x>0){
                    System.out.println("file uploaded successfully....");
                }else {
                    System.out.println("please enter valid path ::");
                }
            }

        }*/
        try (sc;){
            System.out.println("********************WELCOME***********************");
            System.out.println("=============RETRIEVING VIDEO FROM DB============= ");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl"
            ,"SYSTEM","TIGER");
            PreparedStatement pp = con.prepareStatement("SELECT * FROM STREAMTAB WHERE ID= ? ");
            System.out.println("Please ENter id to retrieve video from DB:");
            String id = sc.nextLine();
              pp.setString(1,id);
           ResultSet re = pp.executeQuery();
           if (re.next()){
               Blob b = re.getBlob(2);
               byte by[]=b.getBytes(1,(int)b.length());
               System.out.println("PLEASE ENTER PATH TO STORE VIDEO::");
               FileOutputStream fis = new FileOutputStream(sc.nextLine());
               fis.write(by);
               System.out.println("VIDEO DOWNLOADED SUCCESSFULLY.....");

           }else {
               System.out.println("File not found.....");
           }
        }
    }
}

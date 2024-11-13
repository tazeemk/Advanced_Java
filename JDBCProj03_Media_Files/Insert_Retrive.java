package JDBC_Media_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Collection;
import java.util.Scanner;

public class Insert_Retrive
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
     /*   try(sc;) {
        //Loading Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Creating Connection
            Connection co = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","TIGER");
            PreparedStatement ps = co.prepareStatement("INSERT INTO STREAMTAB VALUES (?,?)");
            System.out.println("PLEASE ENTER THE ID TO STORE IMAGE IN DB :");
            String id = sc.nextLine();
            System.out.println("PLEASE ENTER FILE PATH TO UPLOAD IT IN DB :");
            //Creating file object to store multimedia file in it
            File f = new File(sc.nextLine());
              if(f.exists()) {
                  //this fileinputStream object is holding file data from f and making
                  //connection to Database to follow byte data 
                  FileInputStream fis = new FileInputStream(f);
                  ps.setString(1, id);
                  ps.setBinaryStream(2, fis, f.length());
                  int k = ps.executeUpdate();

                 if(k>0) {
                     System.out.println("media file uploaded successfully....");
                 }
                  }else {
                      System.out.println("invalid path :");

              }
                co.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }*/
        //Retrive multimedia file from database
        System.out.println(" Retriving multimedia file from database :");
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "SYSTEM", "TIGER");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM STREAMTAB WHERE ID =?");
            System.out.println("Please Enter the Id to retrive the media file from DB:");
            String ID = sc.nextLine();

            ps.setString(1,ID);
            ResultSet re = ps.executeQuery();
            if (re.next())
            {
                Blob b = re.getBlob(2);
                byte by[]=b.getBytes(1,(int)b.length());
                System.out.println("ENTER THE PATH TO STORE MFILE DATA");
                File f= new File(sc.nextLine());
                FileOutputStream fos = new FileOutputStream(f);
                fos.write(by);
                System.out.println("File Retrive Successfully...");
            }else {
                System.out.println("Invalid path.......");
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package JDBC_Media_Files;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Mfile
{
  static   Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
                    "SYSTEM","TIGER");
            PreparedStatement ps = con.prepareStatement("INSERT INTO STREAMTAB VALUES(?,?)");

                System.out.println("*************WELCOME************");
                System.out.println("PLEASE ENTER YOUR ID :");
                String i =sc.nextLine();
                         // sc.nextLine();
                System.out.println("PLEASE ENTER FILE PATH :");
                        File f = new File(sc.nextLine());
                        if (f.exists()) {
                            FileInputStream fis = new FileInputStream(f);
                            ps.setString(1, i);
                            ps.setBinaryStream(2, fis, f.length());
                            int x = ps.executeUpdate();

                            if (x > 0) {
                                System.out.println("FILE UPLOADED SUCCESSFULLY......");
                            } else {
                                System.out.println("INVALID PATH......");
                            }
                        }
        }catch (Exception e){

        }
    }
}

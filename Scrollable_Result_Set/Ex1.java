package Scrollable_Result_Set;

import java.sql.*;

public class Ex1
{
    public static void main(String[] args) {
        try {
            //by USING SCROLLABLE RESULT SET WE CAN SET AUR RESULT DATA IN FORWARD,BACKWARD,
            // AT ANY SPECIFIC ROW WISE

            //Loading Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //Creating Connection
            Connection com = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","TIGER");
            //Preparing Statement we can prepare statment by using three interfaces
            //Statemen interface,PrepraredStatemne,
            PreparedStatement ps = com.prepareStatement("SELECT * FROM PRODUCT66", ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

                ResultSet re = ps.executeQuery();
            System.out.println("***********PreparedStatement********");
            System.out.println("===Absolute meth()===");
            re.absolute(2);//We can go any row just put row no as parameter
            System.out.println(re.getInt(1)+" "+re.getString(2)+" "+
                    re.getLong(3)+" "+re.getInt(4)+" "+re.getString(5));
            System.out.println("-----------------------------------------------------------------\n");
            System.out.println("===AfterLast meth()===");
            System.out.println("Exception Occur");
        //Exception Data Not found
           //  re.afterLast();
            //System.out.println(re.getInt(1)+" "+re.getString(2)+" "+
              //      re.getLong(3)+" "+re.getInt(4)+" "+re.getString(5));
            System.out.println("----------------------------------------------------------------\n");
            System.out.println("======Fisrt meth()===");
            re.first();//It shows first row of DB
            System.out.println(re.getInt(1)+" "+re.getString(2)+" "+
                    re.getLong(3)+" "+re.getInt(4)+" "+re.getString(5));
            System.out.println("----------------------------------------------------------------\n");
            System.out.println("===relative meth()===");
            re.relative(2);//it will go from current pointer row to jump to given number which
            //we give as a parameter minus means it go up side of table and plus means go down side of table
                 System.out.println(re.getInt(1)+" "+re.getString(2)+" "+
                    re.getLong(3)+" "+re.getInt(4)+" "+re.getString(5));
            System.out.println("----------------------------------------------------------------\n");
            System.out.println("===last  ===");
            re.last();//the cursor will go last row of the table
            System.out.println(re.getInt(1)+" "+re.getString(2)+" "+
                    re.getLong(3)+" "+re.getInt(4)+" "+re.getString(5));
            System.out.println("----------------------------------------------------------------\n");
            System.out.println("===Previous meth()===");
            re.previous();//cursor will go one step back from current pointing cursor row
            System.out.println(re.getInt(1)+" "+re.getString(2)+" "+
                    re.getLong(3)+" "+re.getInt(4)+" "+re.getString(5));

            System.out.println("===================================================================\n");
            System.out.println("*****************************STATEMENT***********************************");
            Statement stm = com.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stm.executeQuery("SELECT * FROM PRODUCT66");
            System.out.println("===Absolute meth()===");
            rs.absolute(2);
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+
                    rs.getLong(3)+" "+rs.getInt(4)+" "+rs.getString(5));
        }catch (Exception e){
e.printStackTrace();
        }
    }
}

package hms;
import java.sql.*;
public class Avalid {
    public static boolean check(String uname ,String pass)
    {
        boolean result =false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idp","root","root");
            PreparedStatement ps = con.prepareStatement("select * from Admin where Aid=? and password=?");
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            result = rs.next();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return result;
    }
   
    public static boolean check1(String uname )
    {
        boolean result =false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idp","root","root");
            PreparedStatement ps = con.prepareStatement("select * from Admin where Aid=?");
            ps.setString(1, uname);
            ResultSet rs =ps.executeQuery();
            result = rs.next();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return result;
    }
   
    public static void changePass(String uname,String pass)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idp","root","root");
            PreparedStatement ps = con.prepareStatement("Update Admin set password=? where Aid=?");
            ps.setString(1, pass);
            ps.setString(2, uname);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       
    }
   
}
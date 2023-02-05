package hms;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Suraj
 */
public class Addstudent extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        /* TODO output your page here. You may use following sample code. */
        String Sid = req.getParameter("Sid");
        String Rtype = req.getParameter("Rtype");
        String Block = req.getParameter("Block");
        String Sname = req.getParameter("Sname");
        String Gender = req.getParameter("Gender");
        String Dob = req.getParameter("Dob");
        String Fname = req.getParameter("Fname");
        String Cno = req.getParameter("Cno");
        String Email = req.getParameter("Email");
        String Pswd = req.getParameter("Pswd");
        String College = req.getParameter("College");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Driver is loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/IDP", "root", "root");
            out.println("Connection successful");
            String s = "insert into Addstudent (Sid,Rtype,Block,Sname,Gender,Dob,Fname,Cno,Email,Pswd,College)values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(s);
            stmt.setString(1, Sid);
            stmt.setString(2, Rtype);
            stmt.setString(3, Block);
            stmt.setString(4, Sname);
            stmt.setString(5, Gender);
            stmt.setString(6, Dob);
            stmt.setString(7, Fname);
            stmt.setString(8, Cno);
            stmt.setString(9, Email);
            stmt.setString(10, Pswd);
            stmt.setString(11, College);

            int i = stmt.executeUpdate();
            out.println(i + "record inserted");
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e);
        }

    }

}

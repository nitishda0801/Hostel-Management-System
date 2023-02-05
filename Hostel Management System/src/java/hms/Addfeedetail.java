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
public class Addfeedetail extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        /* TODO output your page here. You may use following sample code. */
        String Sid = req.getParameter("Sid");
        String Rno = req.getParameter("Rno");
        String Block = req.getParameter("Block");
        String Rtype = req.getParameter("Rtype");
        String Cost = req.getParameter("Cost");
        String Amountpaid = req.getParameter("Amountpaid");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Driver is loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/IDP", "root", "root");
            out.println("Connection successful");
            String s = "insert into addfeedetail (Sid,Rno,Block,Rtype,Cost,Amountpaid)values(?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(s);
            stmt.setString(1, Sid);
            stmt.setString(2, Rno);
            stmt.setString(3, Block);
            stmt.setString(4, Rtype);
            stmt.setString(5, Cost);
            stmt.setString(6, Amountpaid);

            int i = stmt.executeUpdate();
            out.println(i + "record inserted");
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e);
        }

    }

}

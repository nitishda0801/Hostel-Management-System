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
public class Addroom extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        /* TODO output your page here. You may use following sample code. */
        String Block = req.getParameter("Block");
        String Rno = req.getParameter("Rno");
        String Rtype = req.getParameter("Rtype");
        String Nobed = req.getParameter("Nobed");
        String Status = req.getParameter("Status");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Driver is loaded");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/IDP", "root", "root");
            out.println("Connection successful");
            String s="insert into addroom (Block,Rno,Rtype,Nobed,Status)values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(s);
            stmt.setString(1, Block);
            stmt.setString(2, Rno);
            stmt.setString(3, Rtype);
            stmt.setString(4, Nobed);
            stmt.setString(5, Status);

            int i = stmt.executeUpdate();
            out.println(i + "record inserted");
        } catch (ClassNotFoundException | SQLException e) {
            out.println(e);
        }

    }


}

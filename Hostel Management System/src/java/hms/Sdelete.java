package hms;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sdelete extends HttpServlet {

    RequestDispatcher rd;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int n = 0;
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String sid = req.getParameter("Sid");
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idp", "root", "root");
            PreparedStatement ps = con.prepareStatement("delete from registerroom where sid=?");
            ps.setString(1, sid);
            ps.executeUpdate();
            PreparedStatement ps1 = con.prepareStatement("delete from addStudent where sid=?");
            ps1.setString(1, sid);
            n = ps1.executeUpdate();
            if (n > 0) {
                out.print("<script>"
                        + "alert('Student Removed')"
                        + "</script>");
                rd = req.getRequestDispatcher("adminHome.html");
                rd.include(req, res);
            } else {
                out.print("<script>"
                        + "alert('Student Not Exist')"
                        + "</script>");
                rd = req.getRequestDispatcher("sDelete.html");
                rd.include(req, res);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

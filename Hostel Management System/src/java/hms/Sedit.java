package hms;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sedit extends HttpServlet {

    RequestDispatcher rd;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        int n = 0;
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String Sid = req.getParameter("Sid");
        String Sname = req.getParameter("Sname");
        String Sdob = req.getParameter("Sdob");
        String Fname = req.getParameter("Fname");
        String Spass = req.getParameter("Spass");
        String Smob = req.getParameter("Smob");
        String Semail = req.getParameter("Semail");
        String Scollege = req.getParameter("Scollege");
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idp", "root", "root");
            PreparedStatement ps = con.prepareStatement("Update addStudent set Sname=?,Dob=?,Fname=?,pswd=?,Cno=?,Email=?,College=? where Sid=? ;");

            ps.setString(1, Sname);
            ps.setString(2, Sdob);
            ps.setString(3, Fname);
            ps.setString(4, Spass);
            ps.setString(5, Smob);
            ps.setString(6, Semail);
            ps.setString(7, Scollege);
            ps.setString(8, Sid);
            n = ps.executeUpdate();
            if (n > 0) {
                out.print("<script>"
                        + "alert('Details Updated')"
                        + "</script>");
                rd = req.getRequestDispatcher("adminHome.html");
                rd.include(req, res);
            } else {
                out.print("<script>"
                        + "alert('Please Try Again')"
                        + "</script>");
                rd = req.getRequestDispatcher("sEdit.html");
                rd.include(req, res);
            }
        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
            System.out.println(e);
        }
    }

}

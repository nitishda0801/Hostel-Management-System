package hms;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String n = request.getParameter("uid");
        String p = request.getParameter("psw");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Drivers are loaded");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/idp", "root", "root");
            out.println("Connection is created");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from AddStudent");
            int l = 1;
            while (rs.next()) {
                if (rs.getString(2).equals(n) && rs.getString(11).equals(p)) {

                    l = 0;
                    break;
                }
            }
            if (l == 0) {
                RequestDispatcher rd = request.getRequestDispatcher("studentHome.html");
                rd.forward(request, response);
            } else {
                out.print("Sorry username or password error");
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
            }

            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            out.println(e);
        }
    }
}

package hms; 
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;
import javax.servlet.http.HttpServlet;
public class ViewAdminDetail extends HttpServlet  
{    
     @Override
     public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");  
         out.println("<html>");  
         try
         {  
           Class.forName("com.mysql.cj.jdbc.Driver");  
             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","root")) {
                 
                 int id=Integer.parseInt(req.getParameter("userid"));
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("select * from hotel"+" where htl_cust_id="+id+";");
                 out.println("<head>\n" +
                         "    <meta charset=\"UTF-8\">\n" +
                         "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                         "    <title>Table</title>\n" +
                         "\n" +
                         "<style>\n" +
                         "    body {\n" +
                         "        padding: 0px;\n" +
                         "        \n" +
                         "        font-family: Verdana, Geneva, Tahoma, sans-serif;\n" +
                         "    }\n" +
                         "    \n" +
                         "    table {\n" +
                         "\n" +
                         "        border-collapse: collapse;\n" +
                         "        width: 800px;\n" +
                         "        height: 200px;\n" +
                         "        border: 1px solid #bdc3c7;\n" +
                         "        box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2), -1px -1px 8px rgba(0, 0, 0, 0.2);\n" +
                         "    }\n" +
                         "     .table {\n" +
                         "        display:flex;\n" +
                         " justify-content:center;\n" +
                         " align-items:center;\n" +
                         " margin:auto;\n" +
                         "    }\n" +
                         "    \n" +
                         "    tr {\n" +
                         "        transition: all .2s ease-in;\n" +
                         "        cursor: pointer;\n" +
                         "    }\n" +
                         "    \n" +
                         "    td {\n" +
                         "        padding: 12px;\n" +
                         "        text-align: left;\n" +
                         "        border-bottom: 1px solid #ddd;\n" +
                         "    }\n" +
                         "    \n" +
                         "    #header {\n" +
                         "        background-color:blue;\n" +
                         "        color: #fff;\n" +
                         "    }\n" +
                         "    \n" +
                         "    h1 \n" +
                         "    {\n" +
                         "        font-weight: 600;\n" +
                         "        text-align: center;\n" +
                         "        background-color: white;\n" +
                         "        color:black;\n" +
                         "        padding: 10px 0px;\n" +
                         "    }\n" +
                         "    tr:hover\n" +
                         "    {\n" +
                         "        background-color:grey;\n" +
                         "        transform: scale(1.1);\n" +
                         "        box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.2), -1px -1px 8px rgba(0, 0, 0, 0.2);\n" +
                         "    }\n" +
                         "    @media only screen and (max-width: 768px) \n" +
                         "    {\n" +
                         "        table\n" +
                         "         {\n" +
                         "            width: 90%;\n" +
                         "        }\n" +
                         "    } \n" +
                         "   .heading\n" +
                         " {\n" +
                         "  display:flex;\n" +
                         " justify-content:center;\n" +
                         " align-items:center;\n" +
                         " margin:auto;\n" +
                         " }\n" +
                         "</style></head><body>");
                 
                 out.println("<div class=\"heading\">\n" +
                         "    <h1>Hotel details</h1>\n" +
                         "</div>");
                 out.println("<div class=\"table\">\n" +
                         "    <table>\n" +
                         "     <th><p style=\"text-align:center;\"></p></th> \n" +  
                         "        <tr id=\"header\">\n" +
                         "            <th>Hotel Name</th>\n" +
                         "            <th>Hotel location</th>\n" +
                         "            <th>Room Type</th>\n" +
                         "            <th>Room Number</th> \n" +
                         "        </tr>");
                 while(rs.next())
                 {
                     
                     out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>");
                     
                 }
                 out.println("</table></div>");
                 out.println("</html></body>");
             }
            }  
           

             catch (ClassNotFoundException | NumberFormatException | SQLException e)
            {  
             out.println("error");  
         }  
     }  
 }  

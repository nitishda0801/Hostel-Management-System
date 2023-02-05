<%-- 
    Document   : aProfile
    Created on : 25-Jun-2022, 7:49:59 pm
    Author     : Suraj Patel
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title>Admin Home Page</title>
        <link rel="stylesheet" href="adminPageStyle.css">
    </head>
    <body>
        <nav>
            <label class="logo">Hostel Management</label>
            <ul>
                <li><a class="active" href="adminHome.html"><i class="fa-solid fa-house" style="color: white;"></i>Home</a></li>
                <li>

                    <a href="#">Admin<i class="fas fa-caret-down"></i></a>
                    <ul>
                        <form action="servlet">

                            <li><a href="aProfile.jsp">View Details</a></li>
                        </form>
                    </ul>
                </li>
                <li>
                    <a href="#">Rooms<i class="fas fa-caret-down"></i></a>
                    <ul>
                        <li><a href="addRoom.html">Add Room</a></li>
                        <li><a href="roomList.jsp">View Rooms</a></li>
                        <li><a href="registerRoom.html">Register Room</a></li>
                        <li><a href="regRoomList.jsp">View Registered Rooms</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Students<i class="fas fa-caret-down"></i></a>
                    <ul>
                        <li><a href="addStudent.html">Add Student</a></li>
                        <li><a href="studentList.jsp">View Student</a></li>
                        <li><a href="sEdit.html">Edit Student</a></li>
                    </ul>
                </li>
                <li><a href="#">Fee Details<i class="fas fa-caret-down"></i></a>
                    <ul>
                        <li><a href="#">Fee Structure</a></li>
                        <li><a href="#">Add Student Fee</a></li>
                        <li><a href="#">View Student Fee Details</a></li>
                    </ul>
                <li><a href="resetPass.html">Change Password</a></li>
                <li><a href="index.html">Logout</a></li>
            </ul>
        </nav>
        <%! String Aid; %>
        <%! String Aname; %>
        <%! String mobile_number; %>
        <%! String pass; %>
        <% ServletContext sc = getServletContext(); %>
        <% HttpSession s=request.getSession();%>
        <% Aid = (String)s.getAttribute("Aid"); %>
        
        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/idp";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement("select * from Admin where Aid=?");
            
            ps.setString(1, Aid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Aid = rs.getString(1);
            Aname = rs.getString(2);
            mobile_number = rs.getString(3);
            pass = rs.getString(4);
      
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        %>
        
        <div style="overflow-x: auto;">
            <table class="content-table">
                <tr>
                    <th colspan="4" style="background-color: darkgreen; text-align: center;height: 40px;color: red;font-size: 25px;font-family:Verdana, Geneva, Tahoma, sans-serif;">Profile</th>
                </tr>
                <tr>
                    <th width="30%">Admin Id:</th>

                    <td><input type="text" id="Aid" style="width: 300px;display: none;" ><%= Aid %></td>
                </tr>
                <tr>
                    <th width="30%">Name: </th>

                    <td><input type="text" id="Aname" style="width: 300px;display: none;" ><%= Aname %></td>
                </tr>
                <tr>
                    <th width="30%">Mobile Number:</th>
                    <td><input type="text" id="mobile_number" style="width: 300px;display: none;" ><%= mobile_number %></td>
                </tr>
                <tr>
                    <th width="30%">password:</th>
                    <td><input type="text" id="Cno" style="width: 300px;display: none;" ><%= pass %></td>
                </tr>

            </table>
        </div>
        
    </body>
</html>
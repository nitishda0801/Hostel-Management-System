<%-- 
    Document   : sFeeDetail
    Created on : 25-Jun-2022, 4:24:50 pm
    Author     : Suraj Patel
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Fee Detail</title>
        <link rel="stylesheet" href="studentPageStyle.css">

        <style>
            .content-table{
                font-family: Verdana, Geneva, Tahoma, sans-serif, Helvetica;
                border-collapse: collapse;
                width: 50%;
                margin: 0;
                margin-left:auto;
                margin-right:auto;

            }
            td,th {
                border: 1px solid grey;
                padding: 10px;
                margin: 0;
                text-align: left;
                background-color:rgb(228, 237, 224);
                height: 20px;
                width: 50%;
            }

            .content-table
            {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%! String Sid; %>
        <%! String Rno; %>
        <%! String Block; %>
        <%! String Rtype; %>
        <%! String cost; %>
        <%! String Amountpaid; %>
        <% ServletContext sc = getServletContext(); %>
        <% HttpSession s=request.getSession();%>
        <% Sid = (String)s.getAttribute("Sid"); %>
        
        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/idp";
            String username = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement("select * from addFeeDetail where Sid=?");
            ps.setString(1, Sid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Sid=rs.getString(1);
            Rno = rs.getString(2);
            Block = rs.getString(3);
            Rtype = rs.getString(4);
            cost = rs.getString(5);
            Amountpaid = rs.getString(6);
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        %>
       
        <header class="header1">

            <div class="mid1">
                <marquee style="font-weight: bold;">This is your Fee Detail</marquee>
            </div>
        </header>
        <header class="header2">
            <div class="left2">
                Hostel Management
            </div>
            <div class="right2">
                <ul class="navbar">
                    <li><a href="studentHome.html" class="active">Home</a></li>
                    <li><a href="#">Fee Detail</a></li>
                    <li><a href="resetPass.html">Change Password</a></li>
                    <li><a href="index.html">Logout</a></li>
                </ul>
            </div>
        </header>
        </br></br></br>

        <div style="overflow-x: auto;">
            <table class="content-table">
                <tr>
                    <th colspan="4" style="background-color: darkgreen; text-align: center;height: 40px;color: red;font-size: 25px;font-family:Verdana, Geneva, Tahoma, sans-serif;">Fee Detail</th>
                </tr>
                <tr>
                    <th width="30%">Student Id:</th>

                    <td><input type="text" id="Sid" style="width: 300px;display: none;" ><%= Sid %></td>
                </tr>
                <tr>
                    <th width="30%">Room Number: </th>

                    <td><input type="text" id="Sname" style="width: 300px;display: none;" ><%= Rno %></td>
                </tr>
                <tr>
                    <th width="30%">Block:</th>
                    <td><input type="text" id="Gender" style="width: 300px;display: none;" ><%= Block %></td>
                </tr>
                <tr>
                    <th width="30%">Room Type:</th>
                    <td><input type="text" id="Cno" style="width: 300px;display: none;" ><%=Rtype%></td>
                </tr>
                <tr>
                    <th width="30%">Total Fees:</th>
                    <td><input type="text" id="Email" style="width: 300px;display: none;" ><%= cost %></td>
                </tr>
                <tr>
                    <th width="30%">Amount Paid:</th>
                    <td><input type="text" id="Rtype" style="width: 300px;display: none;" ><%= Amountpaid %></td>
                </tr>
        

            </table>
        </div>

    </body>
</html>
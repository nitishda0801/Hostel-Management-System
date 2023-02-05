<%-- 
    Document   : roomList
    Created on : 26-Jun-2022, 12:10:15 am
    Author     : Suraj Patel
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Room List</title>

        <style>
            *{
                background: rgb(215, 215, 220);
            }
            .ll{
                margin-left: auto;
                margin-right: auto;
                width:70%;
            }
            td{
                color:rgb(170, 32, 112);
            }
            .data{
                text-align: center;
            }
            .tab{
                position: absolute;
                left: 12%;
                width: 80%;
            }
            .sf{
                display: flex;
                justify-content: center;
            }
        </style>
    </head>
    <body>

        <h1 class="sf">Room List</h1>
        <div style="display: flex;">
            <br><br>
            <%! ResultSet rs;%>
            <table border="2" class="tab" width="70%">

                <thead>
                    <tr>
                        <th>Serial Number</th>
                        <th>Block</th>
                        <th>Room Number</th>
                        <th>Room Type</th>
                        <th>No. of Bed</th>
                        <th>Status</th>

                    </tr>
                </thead>



                <%
                    int c = 1;
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/idp";
                        String username = "root";
                        String password = "root";
                        Connection con = DriverManager.getConnection(url, username, password);
                        Statement st = con.createStatement();
                        rs = st.executeQuery("Select * from addRoom");
                        while (rs.next()) {
                %>
                <tr class="data">
                    <td><%=c++%></td>
                    <td><%=rs.getString(1)%></td>
                    <td><%= rs.getString(2)%></td>
                    <td><%= rs.getString(3)%></td>
                    <td><%= rs.getString(4)%></td>
                    <td><%= rs.getString(5)%></td>
                </tr>


                <%
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                %>






            </table>
        </div>
    </body>
</html>
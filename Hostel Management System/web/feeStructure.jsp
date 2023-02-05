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
        <title>Fee Structure</title>

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
                position: Relative;
                left: 35%;
                width: 30%;
            }
            .sf{
                display: flex;
                justify-content: center;
            }
        </style>
    </head>
    <body>

        <h1 class="sf">Fee Structure Table</h1>
        <div style="display: flex;">
            <br><br>
            <%! ResultSet rs;%>
            <table border="2" class="tab" width="70%">

                <thead>
                    <tr>                      
                        <th>Room Type</th>
                        <th>Total Fee</th>
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
                        rs = st.executeQuery("Select * from feestructure");
                        while (rs.next()) {
                %>
                <tr class="data">
                    <td><%=rs.getString(1)%></td>
                    <td><%= rs.getString(2)%></td>
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
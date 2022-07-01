<%@page import="java.lang.Exception"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.util.logging.Level"%>
<%@ page import="java.util.logging.Logger"%>
<html>
<head>
<title>DB Operation</title>
</head>

 <body>
<%
try{
    Connection con;
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pavidb?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","987654321");
    out.println("<html>"+"database successfully opened."+"</html>");
}catch(SQLException e){}
%>

</body>
</html>

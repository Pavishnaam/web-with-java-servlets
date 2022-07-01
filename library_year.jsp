<%-- 
    Document   : library_year
    Created on : Feb 3, 2022, 10:19:00 AM
    Author     : PAVISHNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import =" java.io.IOException"%>
<%@page import =" java.io.PrintWriter"%>
<%@page import =" java.sql.Connection"%>"
<%@page import=" java.sql.DriverManager"%>
<%@page import ="java.sql.ResultSet"%>
<%@page import ="java.sql.SQLException"%>
<%@page import ="java.sql.Statement"%>
<%@page import ="javax.servlet.ServletException"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LIBRARY</title>
    </head>
    <body>
        <form>
        BOOK YEAR : <input type = "text" name = "year"/>
<br /> <br/><br/>
<input type = "submit" value = "Submit" />
<br /> <br/><br/>

        </form>
        <% try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavidb?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","987654321");
    Statement stmt=conn.createStatement();
    System.out.println("DB connected....");
    int s4=Integer.valueOf(request.getParameter("year"));
    ResultSet rs = stmt.executeQuery("select * from library where year="+s4+";");
while(rs.next()){
       out.println("<h3>"+rs.getString("b_name")+"   -  "+rs.getString("a_name")  + "</h3><br>");
}
        }catch(NumberFormatException e){System.out.println(e);}%>

    </body>
</html>

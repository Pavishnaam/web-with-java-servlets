<%@page import =" java.io.IOException"%>
<%@page import =" java.io.PrintWriter"%>
<%@page import =" java.sql.Connection"%>
<%@page import=" java.sql.DriverManager"%>
<%@page import ="java.sql.ResultSet"%>
<%@page import ="java.sql.SQLException"%>
<%@page import ="java.sql.Statement"%>
<%@page import ="javax.servlet.ServletException"%>
<%@page import ="java.util.logging.Level"%>
<%@page import =" java.util.logging.Logger"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student mark</title>
</head>
<body>
<form>
    Enter Register number : <input type = "text" name = "reg">
<br /> <br/><br/>
<input type = "submit" value = "Submit" /><br/>
 <% 
     try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavidb?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","987654321");
    Statement stmt=conn.createStatement();
    System.out.println("DB connected....");
    int s4=Integer.valueOf(request.getParameter("reg"));
    ResultSet rs = stmt.executeQuery("select * from studmark where reg="+s4+";");
    while(rs.next())
    {
           out.println("<h3> NAME : "+rs.getString("name")+" <br/><br/> PHYSICS :  "+rs.getString("phy") +" <br/><br/> CHEMISTRY :  "+rs.getString("chem") +" <br/><br/> MATHS :  "+rs.getString("maths")+ "</h3><br>");
           int p=Integer.valueOf(rs.getString("phy"));
     int c=Integer.valueOf(rs.getString("chem"));
      int m=Integer.valueOf(rs.getString("maths"));
     if(p>=50 &&c>=50 && m>=50)
           {
 %><h2> Result = PASS </h2><%
           }
else{
%>  <h2>Result = FAIL </h2> <%
}
    }

  }catch(NumberFormatException e){System.out.println(e);}
%>
</form>
</body>
</html>

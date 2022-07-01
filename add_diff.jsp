<%-- 
    Document   : add_diff
    Created on : Feb 1, 2022, 9:38:16 AM
    Author     : PAVISHNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <h:head>
<title>addition _and_difference</title>
</h:head>
<h:body>
<form method="POST">
Enter Number 1 : <input type="number" name="no1"/>
<br><br><br>
Enter Number 2 : <input type="number" name="no2"/>
<br><br><br>
<input type="submit" value="submit"/>
<br><br><br>
</form>

<%
try{
        int a=Integer.valueOf(request.getParameter("no1"));
        int b=Integer.valueOf(request.getParameter("no2"));
        int c = a + b;
        int d = a - b;
    
%>
 <h2> Sum = </h2> <%= c %>
<h2> Difference = </h2> <%= d%>
<%
}catch (NumberFormatException e){ }
%>
</h:body>
</html>

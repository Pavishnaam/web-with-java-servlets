<%-- 
    Document   : add
    Created on : Feb 1, 2022, 9:31:06 AM
    Author     : PAVISHNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>First JSP</title></head>
<body>
<%
int a=100, b=20;
int c = a + b;
%>


<h2>The sum of a and b is ... </h2><%= c %>

<a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
</body>
</html>

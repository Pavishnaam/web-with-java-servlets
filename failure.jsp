<%--
Document : failure
Created on : Aug 24, 2021, 8:26:10 AM
Author : VITCC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> JSP Page</title>
</head>
<body>
<% String username = request.getParameter("username"); %>
<h1> <% out.println(username); %> is an invalid user....</h1>
</body>
</html>
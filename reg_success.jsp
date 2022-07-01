
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success page</title>
</head>
<body>
<% String name = request.getParameter("name"); %>
<% String reg = request.getParameter("reg"); %>
<h1> <% out.println(name); %> and <% out.println(reg); %>  exists in the database </h1>
</body>
</html>
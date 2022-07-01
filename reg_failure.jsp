
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Failure page</title>
</head>
<body>
<% String name = request.getParameter("name"); %>
<% String reg = request.getParameter("reg"); %>
<h1> <% out.println(name); %> and <% out.println(reg); %> does not exists in the database </h1>
</body>
</html>
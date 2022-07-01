<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Odd or Even</title>
</head>
<body>
<form method="get">
Enter a Number : <input type="number" name="no" >
<input type="submit" value="submit">
</form>
<%
try{
int a=Integer.parseInt(request.getParameter("no"));
if (a%2==0)
{
%>
<h1>The number is Even...</h1>
<%
}
else
{
%>
<h1> The number is odd...</h1>
<% }
} catch (NumberFormatException e){ }
%>
</body>
</html>
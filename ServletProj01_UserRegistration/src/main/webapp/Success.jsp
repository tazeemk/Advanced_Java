<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="Ubean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String msg=(String)request.getAttribute("msg");
out.println(msg);
UserBean ub=(UserBean)application.getAttribute("ubean");
out.println("This Page Belongs to"+ub.getName()+"<br>");
%>
<a href="view">View Details</a>
<a href ="logout">Logout</a>
</body>
</html>
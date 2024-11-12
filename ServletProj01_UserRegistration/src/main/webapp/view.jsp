<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="Ubean.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=(String)request.getAttribute("name");
out.println("This page belongs to:"+name+"<br>");

UserBean ub =(UserBean)application.getAttribute("ubean");
out.println("Roll_Number :"+ub.getRoll_no()+" <br>");
out.println("Name :"+ub.getName()+"<br>");
out.println("FatherName :"+ub.getFname()+"<br>");
out.println("Department :"+ub.getDept()+"<br>");
out.println("Address :"+ub.getAddr());
 %>
</body>
</html>

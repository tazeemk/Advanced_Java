<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String fname=(String)request.getAttribute("fname");
UserBean ub=(UserBean)application.getAttribute("ubean");
out.println("This page Belongs to "+fname+"<br>");

%>
<form action="update" method="post">
Address<input type="text" name="uname" value=<%= ub.getAdd() %>><br>
EmailId <input type="text" name="mid" value=<%=ub.getMid() %>><br>
PhoneNumber<input type="text" name="phno" value=<%= ub.getPhno()%>><br>
<input type="Submit" value="UpdateProfile">

</form>
</body>
</html>
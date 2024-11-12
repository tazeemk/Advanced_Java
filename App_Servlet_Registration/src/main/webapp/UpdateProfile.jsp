<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<style>
*{
margin: 0px;
padding:0px;
}
.container{
margin:100px auto;
padding:auto;
width:400px;
height:600px;
box-sizing: border-box;
border-radius: 10px;
box-shadow: 6px 6px 12px 6px aqua;
}


</style>
</head>
<body>
<div class="container">
<%
String fname=(String)request.getAttribute("fname");
String msg=(String)request.getAttribute("msg");
out.println("This Page Belongs to"+fname+"<br>");
out.println(msg);

%>

<a href="view">ViewProfile</a><br>
<a href="logout">Logout</a><br>
</div>
</body>
</html>
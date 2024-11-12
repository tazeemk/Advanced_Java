<%@page import="javax.xml.transform.OutputKeys"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String uname = request.getParameter("uname");
String password =request.getParameter("pword");
String Fname=request.getParameter("fname");
String Lst=request.getParameter("lname");
String city=request.getParameter("cty");
String state =request.getParameter("ste");
String email=request.getParameter("eid");
long phoneNo=Long.parseLong(request.getParameter("num"));

out.println("name :"+uname+"<br>");
out.println("Password :"+password+"<br>");
out.println("FirstName :"+Fname+"<br>");
out.println("LastName :"+Lst+"<br>");
out.println("City :"+city+"<br>");
out.println("State :"+state+"<br>");
out.println("Email ID :"+email+" <br>");
out.println("Phone Number :"+phoneNo+"<br>");


%>
</body>
</html>
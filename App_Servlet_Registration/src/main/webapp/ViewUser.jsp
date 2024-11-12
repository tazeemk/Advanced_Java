<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
*{
margin:0px;
padding:0px;
}
.container
{
box-sizing: border-box;
width:400px;
height:600px;
margin:100px auto;
padding:auto;
box-shadow: 6px 6px 12px 6px aqua;

}
.container h1{
text-align:center;
margin:20px 10px;
padding:auto;
font-family: cursive;
}

</style>
</head>
<body>
<div class="container">
<h1>User Details</h1>
<%
String fname=(String)request.getAttribute("fname");
UserBean ub =(UserBean)application.getAttribute("ubean");
out.println("<br>This page belongs to :"+fname+"<br><br>");
out.println("UserName :"+ub.getUname()+"&nbsp &nbsp <br> <br>"+"PassWord :"+"&nbsp &nbsp <br><br>"+
"FirstName :"+ub.getFname()+"&nbsp &nbsp <br><br>"+"LastName :"+ub.getLname()+"&nbsp &nbsp <br><br>"
+"Address :"+ub.getAdd()+"&nbsp &nbsp <br><br>"+"MailId :"+ub.getMid()+ " &nbsp &nbsp <br><br>"+"PhoneNumber :"+ub.getPhno()+"<br>");


%>
<a href="logout">Logout</a>
<a href="edit">Edit Profile</a>
</div>
</body>
</html>
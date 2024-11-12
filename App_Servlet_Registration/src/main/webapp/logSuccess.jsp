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

}
header{
background: #333;
  color: #fff;
     padding: 1rem 0;
    text-align: center;

}

 a{
text-decoration: underline;
text-shadow: 6px 6px 12px 6px navy;
text-overflow: ellipsis;
margin: 100px auto;

}

</style>
</head>
<body>
<header>
<nav>
<%
UserBean ub =(UserBean)application.getAttribute("ubean");
out.println("<h1>WELCOME USER  :"+ub.getFname()+" <br></h1>");
%>

<ul>
<li><a href="view">View Details</a></li>
<li><a href="logout">Logout</a></li>
</ul>
</nav>
</header>
</body>
</html>
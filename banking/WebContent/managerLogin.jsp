<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Login here </title>
</head>
<body>
<%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
<center>
<h2>Enter your details here</h2>
<form action="LoginController" method="post">
ID:			<input type="text" name="mid" /><br/>
PASSWORD:	<input type="password" name="mpass" /><br/>
	<input type="submit" value="Login" />
</form>
</center>
</body>
</html>
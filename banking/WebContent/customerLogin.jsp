<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer login here</title>
</head>
<body>
<%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
<center>
<h2>Enter your details here</h2>
<form action="LoginControllerCustomer" method="post">
Account no:		<input type="text" name="accno" /><br/>
PASSWORD:		<input type="password" name="accpass" /><br/>
				<input type="submit" value="Login" />
</form>
</center>
</body>
</html>
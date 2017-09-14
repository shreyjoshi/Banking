<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
<center>
<font color="green">
<%
String m=(String)request.getAttribute("msg");
if(m!=null)
	out.println(m);
%>
</font>
<h2>Enter customer Details here...</h2>

<form action="CustomerController" method="post">
Name:		<input type="text" name="cname"/>
<br/>
Address:	<input type="textarea" name="cadd"/>
<br/>
Mobile no:	<input type="text" name="cmob"/>
<br/>
Email id: 	<input type="email" name="cemail"/>
<br/>
Account no:	<input type="text" name="accno"/>
<br/>
Password :	<input type="text" name="accpass"/>
<br/>
Balance:	<input type="text" name="balance"/>
<br/>
			<input type="submit" name="create Account">
</form>
</center>
</body>
</html>
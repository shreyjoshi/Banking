<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CUSTOMER DATA</title>
</head>
<body>
<center>
<h1>Customer Details</h1>
<table border="1">
<tr><th>Name</th><th>Address</th><th>Mobile</th><th>email</th><th>account no</th><th>password</th><th>balance</th></tr>
<%@ page import="java.util.ArrayList,beans.Customer" %>
<%
ArrayList<Customer> al=(ArrayList)request.getAttribute("LIST");  
for(Customer cc:al)
{
%>
<tr>
	<td><%=cc.getCname() %></td>
	<td><%=cc.getCadd() %></td>
	<td><%=cc.getCmob() %></td>
	<td><%=cc.getCemail() %></td>
	<td><%=cc.getAccno() %></td>
	<td><%=cc.getAccpass() %></td>
	<td><%=cc.getBalance() %></td>
</tr>
<%
}
%>
</table>
</center>
</body>
</html>
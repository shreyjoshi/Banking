
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Applied Loans</title>
</head>
<body>
<%@ page import="java.util.ArrayList,beans.Customer" %>
<%
ArrayList<Customer> al=(ArrayList)request.getAttribute("LIST");
int a=al.size();
if(a!=0)
{
%>
<h1>Applied loans data</h1>
<table border="2">
<tr><th>Account no</th><th>loan amount</th><th>loan type</th><th>Loan date</th><th>Loan Description</th></tr>
<%
for(Customer cc:al)
{
%>
<tr>
	<td><%=cc.getAccno() %></td>
	<td><%=cc.getLamount() %></td>
	<td><%=cc.getLtype() %></td>
	<td><%=cc.getDate() %></td>
	<td><%=cc.getLdescription() %></td>
</tr>
<%
}
}
else{
	%>
	<h1>NO data found ...MIGHT NOT APPLIED FOR LOAN!!!!!</h1>
	<%
}
%>
</table>
</body>
</html>
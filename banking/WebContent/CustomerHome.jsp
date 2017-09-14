<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer </title>
</head>
<body>

<h1>Welcome customer 
<%=session.getAttribute("acc no") %> here</h1>
<br/><br/><br/>
<center>
<a href="CheckBalance">check your balance</a>
<br/><br/>
<a href="FundTransfer.jsp">fund transfer..</a>
<br/><br/>
<a href="ApplyLoan.jsp">apply for loan..</a>
</center>
</body>
</html>
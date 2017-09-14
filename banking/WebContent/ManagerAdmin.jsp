<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=request.getAttribute("mid") %>></title>
</head>
<body>
<center>
<a href="createCustomer.jsp">Create customer Account</a>
<br/><br/>
<a href="ViewController">View All Account</a>
<br/><br/>
<a href="ViewLoan.jsp">view loans here</a>

</center>
</body>
</html>
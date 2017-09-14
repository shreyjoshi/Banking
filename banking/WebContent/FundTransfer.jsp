<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Home.</title>
</head>
<body>
<center>
<h1 font color="red"><% 
String status=(String)request.getAttribute("status");
if(status!=null)
out.println(status);%>
</h1>
<h3>Transact your data here..</h3>
<form action="FundTransfer" method="post">
	FROM: <input type="text" value="<%=(String)session.getAttribute("acc no") %>" readonly />
	<br/><br/><br/>
	TO: <input type="text" value="to_acc" name="to_acc" />
	<br/><br/>
	Amount= <input type="text" value="amount" name="amount" />
	<input type="submit" value="transfer" />
</form>

</center>
</body>
</html>
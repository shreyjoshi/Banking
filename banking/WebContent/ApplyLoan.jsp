<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply for loan</title>
</head>
<center>
<body>
<h1>welcome to pnb banking</h1>
<marquee>apply for  loan here...     apply for  loan here...        apply for  loan here...</marquee>
<br/><br/><br/><br/>
<h1>welcome: <%=session.getAttribute("acc no") %></h1>
<br/><br/><br/><br/>
<form action="LoanApplication" method="post">

enter loan amount:   <input type="text" value="enter loan amount" name="lamount" />
<br/><br/>
  enter type of loan: <select name="ltype">
						<datalist>
						<option>Home loan</option>
						<option>Car loan</option>
  						<option>Gold Loan</option>
 						<option>Education loan</option>
 						<option>Personal loan</option>
						</datalist>
						</select>

						<br/><br/>
  enter loan description: <textarea name="ldescription"> </textarea>
  <br/><br/>
  <input type="submit" value="apply for loan" />
</form>
</body>
</center>
</html>
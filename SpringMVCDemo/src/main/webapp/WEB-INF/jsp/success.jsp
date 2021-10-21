<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success page-Expression language demo</title>
</head>
<body>
	<h2>${HeaderStatus}</h2>
	Employee ${employee.empName} created with phone number : $("employee.empPhoneNum") 
	<%-- Employee <%= request.getAttribute("empName") %> created with phone number : <%= request.getAttribute("empPhone") %> --%>
</body>
</html>
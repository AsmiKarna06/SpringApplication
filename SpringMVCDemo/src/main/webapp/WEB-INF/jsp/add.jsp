<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error{
	color:red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<h2>${HeaderStatus}</h2>
<title>Add 2 numbers</title>
</head>
<body>
<!--    <form action="add" modelAttribute="employee" method="POST">
		<errors path="errors" cssClass="error"></errors>
		<errors path="empName">
		Enter name:<input type="text" path="empName" name="empName"><br><br>
		Enter phone<input type="text" path="empPhoneNum" name="empPhoneNum"><br><br>
		Enter age<input type="text"  path="age" name="age"><br><br>
		Enter Date of Birth<input path="dateofBirth" name="dateofBirth" type="date" cssClass="datepicker" ><br><br>
		<input type="submit" name="Create Employee">
	</form>   --> 
 	
	 <springform:form action="add" modelAttribute="employee" method="POST">
		<springform:errors path="errors" cssClass="error"/>
	
	<springform:errors cssClass="error"/>
		<br><br>
		<springform:errors path="empName" cssClass="error"/>
		<springform:label path="empName">Employee Name</springform:label>
		<springform:input path="empName" type="text" />
		<br><br>
		<springform:label path="empPhoneNum">Employee Phone</springform:label>
		<springform:input path="empPhoneNum" />
		<springform:label path="age">Employee Age</springform:label>
		<springform:input path="age" />
		<springform:label path="dateofBirth">Employee Date of Birth(in dd/MMM/yyyy)</springform:label>
		<springform:input path="dateofBirth" type="date" cssClass="datepicker"/>
		<input type="submit" value="Submit">
	</springform:form>  
</body>
</html> 

 
 
 
 
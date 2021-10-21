<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	p{color:red;font-size:30px;}
	h2{color:blue;}
</style>
</head>
<body>
<%= pageContext.getAttribute("GeneralInfo",PageContext.APPLICATION_SCOPE) %>
	<%	//for java Code
		session.setAttribute("isUserLoggedIn", "true");
		String userName=request.getParameter("userName");  //request is called implicit object
		String pwd=request.getParameter("pwd");
		pageContext.setAttribute("userName",userName,pageContext.SESSION_SCOPE);
		//Database code
		String driverName=application.getInitParameter("driverName");
		System.out.println("loading driver" + driverName);  		//will rpint on console
		int hitCount=0;
		if(application.getAttribute("hitCount")!=null)
			hitCount=(Integer)application.getAttribute("hitCount");
		//out.println("You are vistor no:"+hitCount);
		//out.println("Hello"+userName);				//will print on page
	%>
	
<%-- 	<p>JSP Expression <%= userName %>  </p>			<!-- this is jsp expression tag -->
	<h2>Scriptlet <%out.println( userName); %>  </h2>
	 --%>
	<%
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request,response);
	%>

</body>
</html>
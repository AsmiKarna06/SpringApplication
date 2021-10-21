<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jsp Demo</title>
</head>
<body>
<%! 	//declaration tag
int x=10;
Integer hitCount =null;
boolean authenticate(){
	System.out.println("Authenticating");
	hitCount++;
	return true;
}
public int divide(int a, int b){
	return a/b;
} 
%>
	<%	//for java Code
		//servletContext has application scope
		pageContext.setAttribute("GeneralInfo","This is a Webpage to show about Page Context",PageContext.APPLICATION_SCOPE);
		String flag=null;
		if(session.getAttribute("isUserLoggedIn")!=null)
			flag=(String)session.getAttribute("isUserLoggedIn");
		if(flag!=null && flag.equals(true)){
			hitCount =(Integer) application.getAttribute("hitCount");
			System.out.println("hitCount:"+hitCount);
			
			if(hitCount==null || hitCount==0){
				out.println("Welcome to the world of JSP");		//if user is hits first time	
				hitCount=1;	
			}
			else{		
				hitCount++;
				out.println("Welcome back to the world of JSP. You are visitor no: " +hitCount); //if user is hits second time
			}
			//authenticate();
			application.setAttribute("hitCount",hitCount);
			//out.println(authenticate());
		}else{
			System.out.println("Forwaring to login page");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.forward(request,response);
		}
	%>
</body>
</html>
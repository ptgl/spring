<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new user</title>
</head>
<body>
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>
    
    <jsp:useBean id="user" class="csc.training.crud.model.User" scope="request">
    	<jsp:setProperty name="user" property="userid" value="0" />
    	<jsp:setProperty name="user" property="firstName" value="" />
    	<jsp:setProperty name="user" property="lastName" value="" />
    	<jsp:setProperty name="user" property="email" value="" />
    	<jsp:useBean id="dateValue" class="java.util.Date" />
		<jsp:setProperty name="user" property="dob" value="${dateValue}" />
    </jsp:useBean>

    <form method="POST" action='UserController' name="frmAddUser">
        User ID : <input type="text" readonly="readonly" name="userid"
            value="<jsp:getProperty name="user" property="userid" />" /> <br /> 
        First Name : <input
            type="text" name="firstName"
            value="<jsp:getProperty name="user" property="firstName" />" /> <br /> 
        Last Name : <input
            type="text" name="lastName"
            value="<jsp:getProperty name="user" property="lastName" />" /> <br /> 
            
        <%
        	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("MM/dd/yyyy");
        	String dates = formatter.format(((csc.training.crud.model.User)pageContext.getAttribute("user", PageContext.REQUEST_SCOPE)).getDob());
        	if (dates != null)
            	pageContext.setAttribute("dates", dates, PageContext.PAGE_SCOPE);
        	else 
        		pageContext.setAttribute("dates", "", PageContext.PAGE_SCOPE);
        %>    
        DOB : <input
            type="text" name="dob"
            value="<%=pageContext.getAttribute("dates") %>" /> <br /> 
        Email : <input type="text" name="email"
            value="<jsp:getProperty name="user" property="email" />" /> <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>
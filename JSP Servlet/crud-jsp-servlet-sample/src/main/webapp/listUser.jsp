<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>DOB</th>
                <th>Email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
        	<%
        		java.util.List<csc.training.crud.model.User> list = (java.util.List<csc.training.crud.model.User>)request.getAttribute("users");
        		if (list != null){
        			for (csc.training.crud.model.User user : list) {
        	%>
		                <tr>
		                    <td><%=user.getUserid() %></td>
		                    <td><%=user.getFirstName() %></td>
		                    <td><%=user.getLastName() %></td>
		                    
		                    <%
		                    	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MMM-dd");
		                    %>
		                    
		                    <td><%=formatter.format(user.getDob()) %></td>
		                    <td><%=user.getEmail() %></td>
		                    <td><a href="UserController?action=edit&userId=<%=user.getUserid() %>">Update</a></td>
		                    <td><a href="UserController?action=delete&userId=<%=user.getUserid() %>">Delete</a></td>
		        				
		                </tr>
        	<%
        			}
        		}
        	%>
        </tbody>
    </table>
    <p><a href="UserController?action=insert">Add User</a></p>
</body>
</html>
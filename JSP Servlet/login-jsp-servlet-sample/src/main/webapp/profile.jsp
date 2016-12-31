<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("userid")%>
<a href='UserController?action=logout'>Log out</a>

<jsp:useBean id="userInfo" class="csc.training.login.model.User" scope="request" />
		<center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">User Info</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><jsp:getProperty name="userInfo" property="firstName" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><jsp:getProperty name="userInfo" property="lastName" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><jsp:getProperty name="userInfo" property="email" /></td>
                    </tr>
                </tbody>
            </table>
          </center>

<%
    }
%>

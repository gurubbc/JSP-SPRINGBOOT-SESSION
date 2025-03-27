<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Details</title>
</head>
<body>
<%
	HttpSession sess=request.getSession(false);
	if (sess==null || sess.getAttribute("username")==null) {
		out.println("<h1> Please login </h> <br> <a href='/login'>Login</a>");
	} else {
%>


    <h2>Stock Details</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <tr>
            <td>${stock.id}</td>
            <td>${stock.name}</td>
        </tr>
    </table>
    <a href="/logout">Logout</a>
    <%
    
	} %>
</body>
</html>

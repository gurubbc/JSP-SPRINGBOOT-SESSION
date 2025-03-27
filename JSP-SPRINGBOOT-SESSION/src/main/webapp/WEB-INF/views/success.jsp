<%@ page session="true"%>
<!-- Ensure the page is part of a session -->

<%
HttpSession sess = request.getSession(false);
if (sess == null || sess.getAttribute("username") == null) {
	System.out.println("session is null");
	// Redirect to login page if session or user attribute doesn't exist
	response.sendRedirect("login");
} else {
	System.out.println("session is NOT null");
%>
<body>
	<h1>Success</h1>
	<a href="/stock/1">stock1</a><br>
	<a href="/stock/1">stock1</a><br>
	<a href="logout">Logout</a>
</body>
<%
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Books</title>
</head>
<body>
	<div id="centered">
		<jsp:include page="header.jsp" flush="true" />
		<br />
		<jsp:include page="leftColumn.jsp" flush="true" />
		<div>
			<span class="label" style="margin-left: 15px;">List of All
				Books</span>
		</div>
		<jsp:include page="list.jsp" flush="true" />
	</div>
</body>
</html>
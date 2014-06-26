<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="bookstore.model.Book"%>
<%@page import="bookstore.model.Author"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All books</title>
</head>
<body>
	<%
		String category = request.getParameter("category");
		if (category != null) {
	%>
	<div>
		<span class="label" style="margin-left: 15px;"> List of <%=category%>
			Books
		</span>
	</div>

	<%
		}
	%>
	<table id="grid">
		<thead>
			<tr>
				<th id="th-title">Book Title</th>
				<th id="th-author">Author</th>
			</tr>
		</thead>

		<tbody>
			<%
				List<Book> books = (List<Book>) request.getAttribute("bookList");

				for (Book book : books) {
					Long bookId = book.getId();
					List<Author> authors = book.getAuthors();
			%>
			<tr>
				<th scope="row" id="r100"><%=book.getBookTitle()%></th>
				<%
					for (Author author : authors) {
							if (book.getId().equals(author.getBookId())) {
				%><td><%=author.getFirstName() + "  "
								+ author.getLastName()%></td>

				<%
					}
						}
				%>
			</tr>

			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>

<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="net.ddns.pannetwork.entity.Books"%>
<%@page import="java.util.List"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/generalStyle.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/style/generalStyle.css" media="screen" />

<style>

table.principal {
	width: 80%;
	border-spacing: 0;
	margin-top: 20px;
	border: 1px solid black;
	font-family: sans-serif;
}
table.principal th{
	background-color: silver;
	text-align: center;	
	
}

table.principal td {
	text-align: left;
 }
 
 
table.bookInfo {
	width: 450;

	}
	
table.bookInfo td { 
	width: 30%;
	}	
	
img {

	width: 200px;

}	
	
#labelText {
	font-size: 15;
	display: inline-block;

}
	
</style>

<% 
	List<Books> books = (List<Books>) request.getAttribute("booksList");
	
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livros do DB</title>
</head>
<body>

<% for (Books book : books){


 %>

<table class="principal">
	<tr>
		<th>
		<%=book.getTitle()%>
		</th>
	</tr>
	<tr>
		<td>
		 <table class="bodyDivision">
			 <tr>
				 <td>
					 <table class="bookInfo">
						<tr>
							<td>
							<div id="labelText">Código:</div>
							</td>
							<td>
							<%=book.getCode()%>
							</td>
						</tr>
						<tr>
							<td>
							<div id="labelText">Autor:</div>
							</td>
							<td>
							<%=book.getAuthor() %>
							</td>
						</tr>
						<tr>
							<td>
							<div id="labelText">Data Pub:</div>
							</td>
							<td>
							<%=book.getPublicationDate().toString() %>
							</td>
						</tr>
						<tr>
							<td>
							<div id="labelText">Preço (R$)</div>
							</td>
							<td>
							<%=book.getPreis() %>
							</td>
						</tr>
					</table>
				 </td>
				<td>
<!-- 					<img alt="" src="http://d.gr-assets.com/books/1183391942l/1411178.jpg"> -->
						<img alt="" src="${pageContext.request.contextPath}/admin/Imagem?code=<%=book.getCode()%>">
				</td>
			 </tr>
			 <tr>
				 <td><a href="${pageContext.request.contextPath}/admin/listaLivros?code=<%=book.getCode()%>&action=delete">Apagar Livro</a></td>
				 <td></td>
			 </tr>
		 </table>
		</td>	
	</tr>
</table>


<% }%>

</body>
</html>
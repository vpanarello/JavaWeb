<!DOCTYPE>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/generalStyle.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/style/generalStyle.css" media="screen" />

<% 

	String msg = (String) request.getAttribute("feedbackMsg");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Inicial</title>
</head>
<body>

<table id="dialogologin" >
	<tr>
		<td>
		<h3><center>Cadastro Novo Livro</center></h3>
		
		 <form action="novoLivro" method="post" enctype="multipart/form-data">
		 	<label for="codigo">Código:</label><br/>
			<input type="text" name="code" id="code" size="10"><br/>
			<label for="titulo">Título:</label><br/>
			<input type="text" name="title" id="title" size="30"><br/>
			<label for="autor">Autor:</label><br/>
			<input type="text" name="author" id="author" size="30"><br/>
			<label for="data">Data Publicação:</label><br/>
			<input type="text" name="pDate" id="pDate" size="30"><br/>
			
			<label for="preco">Preço (R$):</label><br/>
			<input type="text" name="preis" id="preis" size="30"><br/>
			
			<label for="foto">Foto:</label><br/>
			<input type="file" name="pict" id="pict"/><br/>
			<input type="submit" value="Gravar" style="margin-top: 10; ">
		</form>
		
		<% if(msg != null){ %>
		<p style="text-align: center;"><%=msg%></p>
		<%} %>
		
		</td>
	</tr>
</table>
</body>
</html>
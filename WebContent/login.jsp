<!DOCTYPE>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/generalStyle.css" media="screen" />

<% 

	String msg = (String) request.getAttribute("loginMsg");

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
		<h3>Bem Vindo ao Sistema</h3>
		 <form action="bemvindo" method="post">
			<label for="nome">UserName:</label><br/>
			<input type="text" name="user" id="user" size="30"><br/>
			<label for="senha">Password:</label><br/>
			<input type="password" name="senha" id="senha" size="30"><br/>
			<input type="submit" value="entrar" style="margin-top: 10; ">
		</form>
		
		<% if(msg != null){ %>
		<p style="text-align: center;"><%=msg%></p>
		<%} %>
		
		</td>
	</tr>
</table>
</body>
</html>
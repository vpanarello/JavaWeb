
<%@page import="net.ddns.pannetwork.servlet.ItemLista"%>
<%@page import="java.util.List"%>

<%  
	@SuppressWarnings("unchecked")
	List<ItemLista> itens = (List<ItemLista>) request.getAttribute("listaMenu"); %>

<!DOCTYPE>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/generalStyle.css" media="screen" />
<link rel="stylesheet" type="text/css" href="/style/generalStyle.css" media="screen" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Principal</title>
</head>
<body>
<h3>Menu Principal</h3>

<ul>
	
<% for (ItemLista item : itens) { %>
<li> <a href= "<%=item.getLink()%>" > <%=item.getTitulo()%> </a></li>
<%} %>

</ul>
</body>
</html>
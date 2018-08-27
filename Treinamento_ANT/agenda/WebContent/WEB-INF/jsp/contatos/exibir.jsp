<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Contato</title>
</head>

<body>
	<h2>Dados do Contato</h2>

	<form action="/agenda/contato" method="post">
		Nome: <input type="text" name="contato.nome" placeholder="Digite o nome do contato." value="${contato.nome}" disabled="disabled"> 
		<br> <br>
		Telefone: <input type="text" name="contato.telefone" placeholder="Digite o telefone do contato."  value="${contato.telefone}" disabled="disabled">
		
	</form>
</body>
</html>
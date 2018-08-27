<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Contato</title>
</head>

<body>
	<h2>Editar Contato</h2>

	<form action="/agenda/contato" method="post">
		<input type="hidden" name="_method" value="put"/>
		
		<input type="hidden" name="contato.id" value="${contato.id}">
		Nome: <input type="text" name="contato.nome" placeholder="Digite o nome do contato." value="${contato.nome}"> 
		<br> <br>
		Telefone: <input type="text" name="contato.telefone" placeholder="Digite o telefone do contato."  value="${contato.telefone}">
		
		<input type="submit" value="Alterar"/>
	</form>
</body>
</html>
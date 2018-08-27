<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Agenda de Contato</title>
</head>

<c:url var="link" value="/contato"/>

<body>

	<h2>Listar contatos</h2>
	<a href="/agenda/contato/novo">Novo</a> 
	<br>
	<ul>
	<c:forEach items="${contatoList}" var="contato">
		<li>
		${contato.nome} - ${contato.telefone} - 
		<a href="${link}/${contato.id}/editar">editar</a> - 
		<a href="${link}/${contato.id}">exibir</a> - 
		<a href="${link}/${contato.id}/deletar">deletar</a> 
		</li>
	</c:forEach>
	</ul>

</body>
</html>
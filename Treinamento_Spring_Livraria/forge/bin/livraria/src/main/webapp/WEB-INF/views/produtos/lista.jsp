<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CADASTRO DE PRODUTOS</title>
<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


</head>
<body class="container">
</head>
<body>
	<h1>Lista de Produtos</h1>
	<table class="responsive-table highlight">
	    <thead>    	
	        <tr>
	            <th>Título</th>
	            <th>Descrição</th>
	            <th>Páginas</th>
	        </tr>
        </thead>
        <tbody>
        	<c:forEach items="${produtos}" var="produto">
	        	<tr>
	        		<td>${produto.id }</td>
	        		<td>${produto.nome }</td>
	        		<td>${produto.descricao }</td>
	        	</tr>
	        </c:forEach>
        </tbody>
    </table>
	
	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>

</body>
</html>
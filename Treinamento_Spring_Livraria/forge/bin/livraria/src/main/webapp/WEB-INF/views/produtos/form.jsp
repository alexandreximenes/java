<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

	<div class="row">
		<h1>Cadastro de Produtos</h1>
		${msg}
		<form id="formulario" action="/livraria/produtos" method="POST"
			enctype="multipart/form-data" class="col s12">
			<div class="row">
				<div class="input-field col s12">
					<input name="id" id="id" type="text" class="validate"
						disabled="disabled"> <label for="id">Codigo</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<input name="nome" id="nome" type="text" class="validate" autofocus>
					<label for="nome">Nome</label>
				</div>
			</div>

			<div class="row">
				<div class="input-field col s12">
					<textarea name="descricao" id="descricao"
						class="materialize-textarea" class="validate"></textarea>
					<label for="descricao">Descrição</label>
				</div>
			</div>
			<div class="row">
				<c:forEach items="${tipos}" var="opcao" varStatus="status">
					<div class="s12">
						<div class="input-field col s4">
							<input name="precos[${status.index}].valor"
								id="precos[${status.index}].valor" type="text" class="validate">
							<input name="precos[${status.index}].opcao" type="hidden"
								value="${opcao }"> <label
								for="precos[${status.index}].valor">${opcao }</label>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="row">
				<div class="file-field input-field">
					<div class="btn">
						<span>Arquivo</span> <input type="file" name="sumario"
							id="sumario">
					</div>
					<div class="file-path-wrapper">
						<input class="file-path validate" type="text"
							placeholder="Faça upload de 1 arquivo">
					</div>
				</div>
			</div>
	</div>

	<button class="btn waves-effect waves-light #d81b60 pink darken-1"
		type="submit" name="salvar">
		Salvar <i class="material-icons right">send</i>
	</button>

	</form>

	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>

</body>
</html>
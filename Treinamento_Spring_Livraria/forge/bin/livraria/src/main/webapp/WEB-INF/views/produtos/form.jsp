<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		<form action="produtos" method="post" class="col s12">
			<div class="row">
				<div class="input-field col s12">
					<input name="titulo" id="titulo" type="text"
						class="validate"> <label for="titulo">Titulo</label>
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
				<div class="input-field col s12">
					<input  name="paginas" id="paginas"
						type="text" class="validate"> <label for="paginas">Paginas</label>
				</div>
			</div>
			
			<button class="btn waves-effect waves-light #d81b60 pink darken-1" type="submit"
				name="salvar">
				Salvar <i class="material-icons right">send</i>
			</button>

		</form>
	</div>
	<!-- Compiled and minified JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>

</body>
</html>
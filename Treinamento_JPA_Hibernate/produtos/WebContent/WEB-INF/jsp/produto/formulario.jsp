<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script>
<link type="text/css" href="<c:url value="/css/jquery.css"/>" rel="stylesheet" />
<title>Cadastrar Produto</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
	<form action="<c:url value="/produto/adiciona"/>">
		<h1>Cadastrar Produtos</h1>
		<table class="table table-striped">
			<form>
				<tr>
					<td>Nome:</td>
					<td width="85%"><input name="produto.nome" class="form-control"/></td>
				</tr>
				<tr>
					<td>Descricao:</td>
					<td><input name="produto.descricao" class="form-control"/> </td>
				</tr>
				<tr>
					<td>Preço:  </td>
					<td><input name="produto.preco" class="form-control"/></td>
				</tr>
				<tr>
					<td>Data de início da venda:  </td>
					<td><caelum:campoData id="dataInicioVenda" name="produto.dataInicioVenda" /></td>
				</tr>
			</form>
			</table>
	
		<input type="submit" value="Cadastrar" class="btn btn-danger"/>
	</form>
	
	<c:import url="../include/rodape.jsp" />
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<script src="resources/js/jquery.js"></script>

<script>
	function pagaConta(id){
		return fetch('pagaConta?id='+id)
			.then(r => {
				if(r.ok){
					alert(`Conta paga com sucesso!`); 
				}else{
					alert(`Não foi possivel pagar [erro ${r.statusText} ]`);
				}
			});
	}
</script>



</head>
<body class="container">
Listagem de contas
	<table class="table table-hover table-bordered">
        <tr>
			<th>ID</th>
			<th>Descrição</th>
			<th>Paga ?</th>
			<th>Valor</th>
			<th>Data de pagamento</th>
			<th>Tipo</th>
			<th>Ações</th>
		</tr>
		
		<c:forEach var="conta" items="${contas}">
			<tr>
				<td>${conta.id }</td>
				<td>${conta.descricao }</td>
				<td>
					<c:if test="${conta.paga eq false}">
						Não paga
					</c:if>
					<c:if test="${conta.paga eq true }">
						Paga
					</c:if>
				</td>
				<td>${conta.valor }</td>
				<td><fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy" /></td>
				<td>${conta.tipo}</td>
				<td>
 					<a href="removeConta?id=${conta.id}"><span class="glyphicon glyphicon-trash" aria-hidden="true" title="Remover"></span> </a>
					<c:if test="${conta.paga eq false }">
						| <a onclick="pagaConta(${conta.id})" ><span class="glyphicon glyphicon-usd" aria-hidden="true" title="Pagar"></span></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<a href="formulario" class="btn btn-default"> Cadastrar contas </a>
	<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
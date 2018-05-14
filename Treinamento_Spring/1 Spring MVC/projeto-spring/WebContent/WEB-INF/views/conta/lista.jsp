<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Listagem de contas
	<table style="height: 10px; width: 775px;" border="1">
        <tr>
			<th>ID</th>
			<th>Descrição</th>
			<th>Paga ?</th>
			<th>Valor</th>
			<th>Data de pagamento</th>
			<th>Tipo</th>
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
				<td><a href="removeConta?id=${conta.id}">remover</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<a href="formulario"> Cadastrar contas </a>
</body>
</html>
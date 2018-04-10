<%@page import="br.com.caelum.produtos.modelo.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<title>PRODUTOS</title>
</head>
<body>
	<script type="text/javascript">
		function removeProduto(id){
			$("#mensagem").load('<c:url value="/produto/remove"/>' + '?produto.id=' + id);
			$("#produto" + id).remove();
		}
	</script>

<%-- 				<c:if test="${p.usado }"> --%>
<!-- 					<td>Sim</td>			 -->
<%-- 				</c:if> --%>
<%-- 				<c:if test="${not p.usado }"> --%>
<!-- 					<td>Não</td> -->
<%-- 				</c:if> --%>

	<h1><fmt:message key="mensagem.pagina" /></h1>
	<h2><fmt:message key="mensagem.bemvindo"/></h2>
	<div id="mensagem"></div>
	<table width="100%" class="table table-hover">
		<tr>
			<td>Nome</td>
			<td>Preco</td>
			<td>Descricao</td>
			<td>Data de Inicio da Venda</td>
			<td>Usado?</td>
			<td width="20%">Remover?</td>
		</tr>
		
		<c:forEach var="p" items="${produtoList}">
			<tr>
				<td>${p.nome }</td>
				<td>
					<fmt:formatNumber value="${p.preco }" type="currency" />
				</td>
				<td>${p.descricao }</td>
				<td><fmt:formatDate value="${p.dataInicioVenda.time }" pattern="dd/MM/yyyy" /></td>
				
				<c:choose>
					<c:when test="${p.usado}">
						<td>sim</td>
					</c:when>
					
					<c:otherwise>
						<td>não</td>
					</c:otherwise>
					
				</c:choose>	
				<td><a href="#" onclick="return removeProduto(${p.id})">Remover</a></td>
				
			</tr>
		</c:forEach>
			
	</table>

	<c:url value="/produto/formulario" var="formProduto"></c:url>
	<a href="${formProduto}" class="btn btn-primary"><fmt:message key="mensagem.novoProduto"/></a>
	
	<c:import url="../include/rodape.jsp" />
</body>
</html>
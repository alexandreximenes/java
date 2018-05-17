<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    
</head>
<body class="container">
<h3>Adicionar Contas</h3>
    <form class="form" action="adicionaConta" method="post">
    	
        Descrição: <br/>
        
<!-- 			<div class="alert alert-danger alert-dismissible" role="alert"> -->
<!-- 			  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
<%-- 			  <strong>Ops!</strong><form:errors path="conta.descricao" /> --%>
<!-- 			</div> -->
	
	<form:errors path="conta.descricao" />
		<br/>
        <textarea class="form-control" name="descricao" rows="5" cols="100"></textarea>
        <br/>
        Valor: <input class="form-control" type="text" name="valor" /></br>
        Tipo: <br/>
        <select class="form-control" name="tipo">
            <option value="ENTRADA">Entrada</option>
            <option value="SAIDA">Saída</option>
        </select>
        <br/><br/>
        <input class="btn btn-success" type="submit" value="Adicionar"/>
        <a href="listaContas" class="btn btn-default">Lista de contas</a>
    </form>
    
<hr/>
<p>Bem vindo, ${usuarioLogado.login} <a href="logout" class="btn btn-default">deslogar</a> </p> 
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
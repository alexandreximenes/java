<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado }">
	${usuarioLogado.email }
</c:if>

<form action="controller" method="post">
	<input type="hidden" value="NovaEmpresa" name="tarefa">
	<label for="nome">
		<input type="text" name="nome">
		<input type="submit" value="enviar">
	</label>
</form>

<form action="controller" method="POST">
	<input type="hidden" value="login" name="tarefa">
	<label for="email">Nome:
		<input type="text" name="email">
	</label><br>
	<label for="senha">Senha:
	<input type="password" name="senha">
	</label>
	<input type="submit" value="Entrar">
</form>

<form action="controller" method="POST">
	<input type="hidden" value="logout" name="tarefa">
	<input type="submit" value="logout">
</form>


</body>
</html>
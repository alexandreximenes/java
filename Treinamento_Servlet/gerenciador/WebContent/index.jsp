<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioInvalido}">
	 ${usuarioInvalido}
</c:if>


<c:if test="${not empty usuarioLogado}">
	Acessando a pagina como ${usuarioLogado.email}
</c:if>

</br>
<a href="executa?tarefa=CadastrarEmpresa" >nova empresa</a>
</br>
<form action="executa?tarefa=Login" method="POST">
		EMAIL: <input type="text" name="email" required="required"></br>
		SENHA: <input type="password" name="senha" required="required"></br>
		<input type="submit" value="Acessar">
	</form>
	
	<form action="executa?tarefa=Logout" method="POST">
		<button type="submit">Deslogar</button>
	</form>
	
</body>
</html>
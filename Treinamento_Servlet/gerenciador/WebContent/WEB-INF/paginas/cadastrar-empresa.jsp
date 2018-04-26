<html>
<body>
<h1>Cadastrar Empresa</h1>
</hr>

	
	<form action="executa?tarefa=CadastrarEmpresa" method="POST">
		<label for="empresa">Empresa: </label>
		<input type="text" name="empresa" required="required"></br>
		<button type="submit">Cadastrar</button>
	</form>
	
	</hr>
	
	Empresa cadastrada com sucesso: ${empresa.nome}

</body>
</html>
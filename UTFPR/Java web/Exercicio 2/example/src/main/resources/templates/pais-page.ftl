<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<body>

<div class="container-fluid">
    <div class="jumbotron">
        <h1>Bootstrap Tutorial</h1>
        <p>Bootstrap is the most popular HTML, CSS...</p>
    </div>

    <#if paisAtual??>
        <form action="/update/${(paisAtual.id)!}" method="POST">
    <#else>
        <form action="/create" method="POST">
    </#if>

        <div class="form-group">
            <label for="nome">Nome do pais</label>
            <input value="${(paisAtual.nome)!}" type="text" class="form-control" placeholder="Nome do pais" id="nome">
        </div>
        <div class="form-group">
            <label for="sigla">Sigla</label>
            <input value="${(paisAtual.sigla)!}" type="text" class="form-control" placeholder="Sigla do pais" id="sigla">
        </div>


        <#if paisAtual??>
            <input type="submit" class="btn btn-warning" value="Alterar"></input>
        <#else>
            <input type="submit" class="btn btn-primary" value="Salvar"></input>
        </#if>

    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Sigra</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>

        <#list listaPaises as pais>
            <tr>
                <td>${pais.nome}</td>
                <td>${pais.sigla}</td>
                <td>
                    <a href="/prepare-update?id=${pais.id}" class="btn btn-warning">Alterar</a>
                    <a href="/deletar?id=${pais.id}" class="btn btn-danger">Excluir</a>
                </td>
            </tr>

        </#list>
        </tbody>
    </table>


</div>


<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
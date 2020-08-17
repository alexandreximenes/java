-- 1 - Obter o nome do cantor que possui o menor número de
-- gravações (deve exibir todos os nomes de cantores que tenham
-- o valor mínimo).
SELECT c.nome_cantor, count(g.cod_gravacao) as num_gravacao FROM dml.cantor c
INNER JOIN dml.gravacao g on c.cod_cantor = g.cod_cantor
group by c.nome_cantor 
having count(g.cod_gravacao) = 1;


-- 2 - Obter o nome do cantor que gravou com o maior número de gravadoras diferentes.
select nome_cantor, count(distinct cod_gravadora) as num_gravadoras from dml.gravacao g 
inner join dml.cantor c on g.cod_cantor = c.cod_cantor
group by c.cod_cantor
having count(distinct cod_gravadora) =
(select max(qtde) from (select count(distinct cod_gravadora) as qtde from dml.gravacao
group by cod_cantor) as tmp);


-- 3 - Obter o nome do cantor que possui a maior média de duração de gravações.
SELECT c.nome_cantor as nome_cantor, avg(m.duracao) as media FROM dml.musica m
inner join gravacao g on g.cod_musica = m.cod_musica
inner join cantor c on c.cod_cantor = g.cod_cantor
group by nome_cantor
order by media desc
limit 1;


-- 4 - Selecionar os cantores que nunca gravaram música com a gravadora Sony.
select distinct(c.nome_cantor) as nome_cantor from cantor c 
 left join gravacao g on g.cod_cantor = c.cod_cantor
 left join gravadora gr on gr.cod_gravadora = g.cod_gravadora
where g.cod_cantor not in(
	select gravacao.cod_cantor from gravacao
	inner join gravadora on gravacao.cod_gravadora = gravadora.cod_gravadora
	where gravadora.nome_gravadora = 'Sony'
	)
or c.cod_cantor not in(select gravacao.cod_cantor from gravacao)
order by c.nome_cantor asc;


-- 5 - Selecione o nome das músicas, nome dos cantores e as datas de gravação, para as gravações do ano de 2004.
select c.nome_cantor as cantor, m.titulo as musica, g.data_gravacao as data_gravacao from gravacao g
join musica m on m.cod_musica = g.cod_musica 
join cantor c on c.cod_cantor = g.cod_cantor
where to_char(g.data_gravacao,'YYYY')='2004'
order by musica desc;


-- 6 - Selecione o nome de cada cantor e a data da sua última
-- gravação em ordem decrescente de data. Caso não tenha gravado
-- nada, a data deve aparecer em branco.
select max(g.data_gravacao) as data_ultima_gravacao, c.nome_cantor from cantor c
left join gravacao g on g.cod_cantor = c.cod_cantor
group by c.nome_cantor
order by data_ultima_gravacao desc;


-- 7 - Dadas as tabelas pessoa e fone, retorne os números de
-- telefone residencial, comercial e Celular de cada pessoa. O
-- retorno deve conter uma linha para cada pessoa, com a coluna
-- nome, seguida dos números.
select p.nome_pessoa, f.numero as fone_residencial, f2.numero as fone_comercial, f3.numero as celular
from dml.pessoa p join dml.fone f on p.cod_pessoa = f.cod_pessoa and f.tipo = 'R'
join dml.fone f2 on p.cod_pessoa = f2.cod_pessoa and f2.tipo = 'C'
join dml.fone f3 on p.cod_pessoa = f3.cod_pessoa and f3.tipo = 'L';
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Produto</title>
</head>
<body>
<form action="novoProduto" method="post">
	Nome: <input type="text" name="nome"/>
	Unidade Compra: <input type="number" name="unidadeCompra"/>
	Descricão: <input type="text" name="descricao"/><br>
	Quantidade Previsto Mês: <input type="number" name="qtdPrevistoMes"/>
	Preco Máximo Comprado: <input type="number" name="precoMaxComprado"/><br>
	
	<input type="submit" />
</form> 

<a href="readServlet">Ver Produtos</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="server.entity.Custo" %>
<% Custo custo = (Custo) request.getAttribute("custo"); %>    

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Alterar Custo</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="container-center">
		<div class="container-form">
			<form class="generic-form" action="alterarCusto" method="POST">
				<h1> Alterar Custo </h1>
				<input type="text" name="codigo" placeholder="Código" value="<%= custo.getId() %>" readonly required>
                <input type="text" name="descricao" placeholder="Descrição" value="<%= custo.getDescricaoCusto() %>" required>
				<input type="text" name="valorMensal" placeholder="Valor Mensal" value="<%= custo.getValorMensal() %>" required>
				<select name="ativo" required>
					<option>Ativo</option>
					<option>Inativo</option>
				</select>
				<div class="buttons">
					<input type="button" value="Alterar" onclick="alterarCusto()">
					<a href="buscarCustos"> Cancelar </a>
				</div>
			</form>
		</div>
	</div>
	
	<script src="scripts/scriptCustos.js"></script>
</body>
</html>
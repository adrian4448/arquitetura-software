<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="server.entity.Investimento"%>
<% Investimento investimento = (Investimento) request.getAttribute("investimento"); %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Alterar Investimento</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container-center">
		<div class="container-form">
			<form class="generic-form" action="alterarInvestimento" method="POST"> 
				<h1> Alterar Investimento </h1>
				<input type="text" placeholder="Código" value="<%= investimento.getId() %>" name="codigo" readonly>
				<input type="text" placeholder="Descrição" value="<%= investimento.getTipoInvestimento() %>" name="tipoInvestimento">
				<input type="number" placeholder="Valor Investido" value="<%= investimento.getValorInvestido() %>" name="valorInvestido">
				<input type="number" placeholder="Renda Mensal (%)" value="<%= investimento.getRendaDiaria() %>" name="rendaDiaria">
				<input type="date" value="<%= investimento.getDtInicio() %>" name="dtInicio">
				<input type="date" value="<%= investimento.getDtFim() %>" name="dtFim">
				<div class="buttons">
					<input type="button" value="Alterar" onclick="cadastrarInvestimento()">
					<a href="buscarInvestimentos"> Voltar </a>
				</div>
			</form>
		</div>
	</div>
	
	<script src="scripts/scriptInvestimento.js"></script>
</body>
</html>
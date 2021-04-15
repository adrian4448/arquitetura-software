<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "server.entity.Funcionario" %>

<% ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) request.getAttribute("funcionarios"); %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Calcular Salario</title>
</head>
<body>
    <div class="container">
        <h1> Calcular Salario </h1>
        <form class="form-cadastro" action="calcular"> 
            <input class="input-text" type="text" name="horasTrabalhadas" placeholder=" Horas trabalhadas">
            <div class="datas">
            	<input class="input-text" type="date" name="dataTrabalhada" placeholder=" Data de Inicio">       
            </div>
            <select class="combo-box" name="idFuncionario" required>
			<%
				for(Funcionario func : funcionarios) {
			%>
				<option data-id="<%= func.getCodigo() %>"> <%= func.getNome() %> </option>		
			<% 	} %>
            </select>
            <input class="input-button" type="button" value="Calcular" onclick="calcularSalario()">
        </form>
        
    </div>
    <script src="Script/calcularSalario.js"></script>
</body>
</html>
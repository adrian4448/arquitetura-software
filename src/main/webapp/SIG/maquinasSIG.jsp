<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="server.entity.Maquina" %>

<% List<Maquina> maquinas = (List<Maquina>) request.getAttribute("maquinas"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Maquinas</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container-center">
            <form class="buttons" action="maquinasServlet" method="POST">
                <input type="button" class="btn-adicionar" value="Comprar Maquina" onclick="document.querySelector('.buttons').submit();"> 
                <a class="btn-adicionar" href="inicioSIG.html"> Voltar </a>
            </form>
            <table class="generic-table">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Maquina</th>
                        <th>Renda Bruta</th>
                    </tr>
                </thead>
                <tbody>
                    <% for(Maquina maquina : maquinas) { %>
                    <tr>
                        <td><%= maquina.getId() %></td>
                        <td><%= maquina.getDescMaquina() %></td>
                        <td><%= maquina.getRenda() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
	</div>
</body>
</html>
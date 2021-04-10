package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import server.dao.DaoFactory;
import server.dao.daoInterfaces.FuncionarioInterface;
import server.entity.Funcionario;

@WebServlet(urlPatterns = { "/CalcularSalario", "/calcular" })
public class CalcularSalario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private FuncionarioInterface funcionarioDao = DaoFactory.createFuncionarioDao();	
	
    public CalcularSalario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!"/calcular".equals(request.getServletPath())) {
			ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) funcionarioDao.getFuncionarios(); 
			request.setAttribute("funcionarios", funcionarios);
			RequestDispatcher rd = request.getRequestDispatcher("calcularSalario.jsp");
			rd.forward(request, response);
		}else {
			calcular(request, response);
		}		
	}

	private void calcular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Funcionario func = new Funcionario();
		func.setHorasTrabalhadas(Integer.parseInt(request.getParameter("horasTrabalhadas")));
		func.setCodigo(Integer.parseInt(request.getParameter("idFuncionario")));
		func.setDtTrabalhado(LocalDate.parse(request.getParameter("dataTrabalhada")));
		funcionarioDao.calcularSalario(func);
		response.sendRedirect("folhaPagamento.html");
	}
	
}

package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.DaoFactory;
import server.dao.daoInterfaces.FuncionarioInterface;
import server.entity.Funcionario;

@WebServlet("/gastosPeriodo")
public class gastosPeriodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public gastosPeriodo() {
        super();
    }

    FuncionarioInterface funcionarioDao = DaoFactory.createFuncionarioDao();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("DT_INICIO", LocalDate.parse(request.getParameter("dataInicial")));
		parametros.put("DT_FIM", LocalDate.parse(request.getParameter("dataFinal")));
		ArrayList<Funcionario> funcionarios = ( ArrayList<Funcionario> ) funcionarioDao.gastosPeriodo(parametros);
		request.setAttribute("funcionarios", funcionarios);
		RequestDispatcher rq = request.getRequestDispatcher("gastosPeriodo.jsp");
		rq.forward(request, response);
	}

}

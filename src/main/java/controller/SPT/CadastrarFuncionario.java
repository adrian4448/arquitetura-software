package controller.SPT;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.DaoFactory;
import server.dao.daoInterfaces.FuncionarioInterface;
import server.entity.Funcionario;

@WebServlet("/SPT/CadastrarFuncionario")
public class CadastrarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FuncionarioInterface funcionarioDao = DaoFactory.createFuncionarioDao();	
	
    public CadastrarFuncionario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Funcionario funcionario = new Funcionario();
		Double valorHoras = Double.parseDouble(request.getParameter("valorHoras"));
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setValorHoras(valorHoras);
		funcionario.setAtivo(funcionarioAtivo(request.getParameter("ativo")));
		funcionarioDao.cadastrarFuncionario(funcionario);
		response.sendRedirect("inicioSPT.html");
	}
	
	private Integer funcionarioAtivo(String ativo) {
		if("Ativo".equals(ativo)) {
			return 1;
		}else {
			return 0;
		}
	}
	
}

package controller.SIG.custos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.DaoFactory;
import server.entity.Custo;

@WebServlet("/SIG/alterarCusto")
public class alterarCusto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public alterarCusto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Custo custo = DaoFactory.createCustoDao().getCusto(Integer.parseInt(request.getParameter("codigo")));
		request.setAttribute("custo", custo);
		RequestDispatcher rd = request.getRequestDispatcher("alterarCusto.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Custo custo = new Custo();
		custo.setId(Integer.parseInt(request.getParameter("codigo")));
		custo.setDescricaoCusto(request.getParameter("descricao"));
		custo.setValorMensal(Double.parseDouble(request.getParameter("valorMensal")));
		custo.setAtivo(1);
		DaoFactory.createCustoDao().alterarCusto(custo);
		response.sendRedirect("buscarCustos");
	}

}

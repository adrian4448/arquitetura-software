package controller.SIG.investimentos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.DaoFactory;
import server.entity.Investimento;

@WebServlet("/SIG/buscarInvestimentos")
public class buscarInvestimentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public buscarInvestimentos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Investimento> investimentos = DaoFactory.createInvestimentoDao().getAllInvestimentos();
		request.setAttribute("investimentos", investimentos);
		RequestDispatcher rq = request.getRequestDispatcher("investimentoSIG.jsp");
		rq.forward(request, response);
	}

}

package controller.SIG.investimentos;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.DaoFactory;
import server.entity.Investimento;

@WebServlet("/SIG/alterarInvestimento")
public class alterarInvestimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public alterarInvestimento() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("codigo"));
		Investimento investimento = DaoFactory.createInvestimentoDao().getInvestimentoById(id);
		request.setAttribute("investimento", investimento);
		request.getRequestDispatcher("alterarInvestimento.jsp").forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Investimento investimento = new Investimento();
		investimento.setId(Integer.parseInt(request.getParameter("codigo")));
		investimento.setTipoInvestimento(request.getParameter("tipoInvestimento"));
		investimento.setRendaDiaria(Double.parseDouble(request.getParameter("rendaDiaria")));
		investimento.setValorInvestido(Double.parseDouble(request.getParameter("valorInvestido")));
		investimento.setDtInicio(LocalDate.parse(request.getParameter("dtInicio")));
		investimento.setDtFim(LocalDate.parse(request.getParameter("dtFim")));
		DaoFactory.createInvestimentoDao().alterarInvestimento(investimento);
		response.sendRedirect("buscarInvestimentos");
	}

}

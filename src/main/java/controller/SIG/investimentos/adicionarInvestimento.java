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

@WebServlet("/SIG/adicionarInvestimento")
public class adicionarInvestimento extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public adicionarInvestimento() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Investimento investimento = new Investimento();
		investimento.setTipoInvestimento(request.getParameter("tipoInvestimento"));
		investimento.setRendaDiaria(Double.parseDouble(request.getParameter("rendaDiaria")));
		investimento.setValorInvestido(Double.parseDouble(request.getParameter("valorInvestido")));
		investimento.setDtInicio(LocalDate.parse(request.getParameter("dtInicio")));
		investimento.setDtFim(LocalDate.parse(request.getParameter("dtFim")));
		DaoFactory.createInvestimentoDao().adicionarInvestimento(investimento);
		response.sendRedirect("buscarInvestimentos");
	}

}

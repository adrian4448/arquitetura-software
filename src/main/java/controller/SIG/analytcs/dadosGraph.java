package controller.SIG.analytcs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import server.dao.DaoFactory;
import server.entity.Custo;
import server.entity.Investimento;

@WebServlet(urlPatterns = {"/SIG/graphCustos", "/SIG/graphInvestimentos" } )
public class dadosGraph extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public dadosGraph() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("/SIG/graphCustos".equals(request.getServletPath())) {
			dadosGraficoCustos(request, response);
		}else if("/SIG/graphInvestimentos".equals(request.getServletPath())) {
			dadosGraficoInvestimentos(request, response);
		}
	}
	
	private void dadosGraficoCustos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		List<Custo> custos = DaoFactory.createCustoDao().getAllCustos();
		Gson jsonFormatter = new Gson();
		String json = jsonFormatter.toJson(custos);
		response.getWriter().write(json);
	}
	
	private void dadosGraficoInvestimentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Investimento> investimentos = DaoFactory.createInvestimentoDao().getAllInvestimentos();
		Gson jsonFormatter = new Gson();
		String json = jsonFormatter.toJson(investimentos);
		response.getWriter().write(json);
	}
	
}

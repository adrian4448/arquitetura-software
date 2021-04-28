package controller.SIG.custos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.DaoFactory;
import server.entity.Custo;

@WebServlet("/SIG/buscarCustos")
public class buscarCustos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public buscarCustos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Custo> custos = DaoFactory.createCustoDao().getAllCustos();
		request.setAttribute("custos", custos);
		RequestDispatcher rd = request.getRequestDispatcher("custosSIG.jsp");
		rd.forward(request, response);
	}

}

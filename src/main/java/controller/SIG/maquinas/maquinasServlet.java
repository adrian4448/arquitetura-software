package controller.SIG.maquinas;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.DaoFactory;
import server.entity.Maquina;

@WebServlet("/SIG/maquinasServlet")
public class maquinasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public maquinasServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Maquina> maquinas = DaoFactory.createMaquinaDao().getMaquinas();
		request.setAttribute("maquinas", maquinas);
		request.getRequestDispatcher("maquinasSIG.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory.createMaquinaDao().comprarMaquina();
		response.sendRedirect("maquinasServlet");
	}

}

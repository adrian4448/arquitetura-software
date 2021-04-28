package controller.SIG.custos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.dao.DaoFactory;
import server.entity.Custo;

@WebServlet("/SIG/cadastrarCusto")
public class cadastrarCusto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public cadastrarCusto() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Custo custo = new Custo();
		custo.setDescricaoCusto(request.getParameter("descricao"));
		custo.setValorMensal(Double.parseDouble(request.getParameter("valorMensal")));
		custo.setAtivo(converteAtivo(request.getParameter("ativo")));
		DaoFactory.createCustoDao().addCusto(custo);
		response.sendRedirect("buscarCustos");
	}
	
	protected Integer converteAtivo(String ativo) {
		if("ativo".equalsIgnoreCase(ativo)) {
			return 1;
		}else {
			return 0;
		}
	}
	
}

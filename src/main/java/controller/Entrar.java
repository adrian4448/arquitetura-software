package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/SPT", "/SIG"})
public class Entrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Entrar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("/SPT".equals(request.getServletPath())) {
			response.sendRedirect("SPT/inicioSPT.html");
		}else if("/SIG".equals(request.getServletPath())) {
			response.sendRedirect("");
		} 
	}

}

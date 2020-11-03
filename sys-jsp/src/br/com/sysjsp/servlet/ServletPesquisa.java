package br.com.sysjsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.AcessoJsp;
import br.com.sysjsp.dao.UsuarioDao;

@WebServlet("/servletPesquisa")
public class ServletPesquisa extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao usuarioDao = new UsuarioDao();
       
    public ServletPesquisa() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String descricaoconsulta = request.getParameter("descricaoconsulta");
		
		if (descricaoconsulta != null || !descricaoconsulta.isEmpty() && !descricaoconsulta.trim().isEmpty()) {
			
			List<AcessoJsp> listaPesquisa = usuarioDao.pesquisarUsuarios(descricaoconsulta.toLowerCase());
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrousuarios.jsp");
			request.setAttribute("usuarios", listaPesquisa);
			view.forward(request, response);
			
		} else {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrousuarios.jsp");
			request.setAttribute("usuarios", usuarioDao.listarTodos());
			view.forward(request, response);
			
		}
	}

}

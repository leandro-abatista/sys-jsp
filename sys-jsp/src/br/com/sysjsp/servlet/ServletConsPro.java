package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.dao.ProdutoDao;

@WebServlet("/ServletConsPro")
public class ServletConsPro extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao = new ProdutoDao();
       
    public ServletConsPro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao.equalsIgnoreCase("listartodos")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/consultaprodutos.jsp");
			request.setAttribute("produtos", produtoDao.listarTodosP());
			view.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/consultaprodutos.jsp");
			request.setAttribute("produtos", produtoDao.listarTodosP());
			view.forward(request, response);
			
		}
	}

}

package br.com.sysjsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.dao.ProdutoDao;

/**
 * Servlet implementation class ServletProduto
 */
@WebServlet("/ServletProduto")
public class ServletProduto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao = new ProdutoDao();
       
    public ServletProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

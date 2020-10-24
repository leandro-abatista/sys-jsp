package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTelefone
 */
@WebServlet("/ServletTelefone")
public class ServletTelefone extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ServletTelefone() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Aqui eu capto o usuário que eu quero gravar o telefone*/
		String cli = request.getParameter("cli");
		/*Aqui eu seto o objeto*/
		request.getSession().setAttribute("cli", cli);
		
		/*Esse 'RequestDispatcher' realizar o redirecionamento para a página desejada*/
		RequestDispatcher view = request.getRequestDispatcher("/cadastrotelefones.jsp");
		//request.setAttribute("telefones", clienteDao.listarTodos());
		request.setAttribute("cliSelecionado", cli);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

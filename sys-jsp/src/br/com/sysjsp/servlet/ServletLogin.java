package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.AcessoJsp;
import br.com.sysjsp.dao.LoginDao;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private LoginDao dao = new LoginDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			AcessoJsp acesso = new AcessoJsp();
			
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			
			if (usuario != null && !usuario.isEmpty() && senha != null && !senha.isEmpty()) {
				
				if (dao.validarLogin(usuario, senha)) {
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("menu.jsp");
					dispatcher.forward(request, response);
				} else {
					/*caso o usuario não tenha acesso ao sistema*/
					RequestDispatcher dispatcher = request.getRequestDispatcher("acessonegado.jsp");
					dispatcher.forward(request, response);
				}
				
			} else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

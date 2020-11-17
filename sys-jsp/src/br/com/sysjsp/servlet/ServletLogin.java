package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (Boolean.parseBoolean(request.getParameter("deslogar"))) {
			HttpServletRequest http = (HttpServletRequest) request;
			HttpSession session = http.getSession();
			session.invalidate();
			// redireciona para a página de index para realizar o login novamente, para ter
			// acesso ao sistema
			response.sendRedirect("/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			//parametros da página index.jsp
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			
			String url = request.getParameter("url");
			
			AcessoJsp acesso = new AcessoJsp();
			
			if (usuario != null && !usuario.isEmpty() && senha != null && !senha.isEmpty()) {
				
				if (dao.validarLogin(usuario, senha)) {
					
					acesso.setUsuario(usuario);
					acesso.setSenha(senha);
					
					// adiciona usuário logado na sessão
					HttpServletRequest http = (HttpServletRequest) request;
					HttpSession session = http.getSession();
					session.setAttribute("usuar", acesso);
					//redireciona para o sistema e autoriza
					RequestDispatcher dispatcher = request.getRequestDispatcher("url");
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

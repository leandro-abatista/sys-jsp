package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.AcessoJsp;
import br.com.sysjsp.dao.UsuarioDao;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioDao dao = new UsuarioDao();
       
   
    public ServletUsuario() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String user = request.getParameter("user");
		
		if (acao.equalsIgnoreCase("delete")) {
			dao.deleteU(user);
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrousuarios.jsp");
			request.setAttribute("usuarios", dao.listarTodos());
			view.forward(request, response);
			
		} else if(acao.equalsIgnoreCase("update")){
			AcessoJsp acessoJsp = dao.consultarU(user);
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrousuarios.jsp");
			request.setAttribute("user", acessoJsp);
			view.forward(request, response);
			
		} else if(acao.equalsIgnoreCase("listartodos")){
	
			RequestDispatcher view = request.getRequestDispatcher("/cadastrousuarios.jsp");
			request.setAttribute("usuarios", dao.listarTodos());
			view.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrousuarios.jsp");
			request.setAttribute("usuarios", dao.listarTodos());
			view.forward(request, response);
			
		} else {
			
			String id = request.getParameter("id");
			String primeironome = request.getParameter("primeironome");
			String sobrenome = request.getParameter("sobrenome");
			String ultimonome = request.getParameter("ultimonome");
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			String telefone = request.getParameter("telefone");
			String email = request.getParameter("email");
			String perfil = request.getParameter("perfil");
			
			AcessoJsp acesso = new AcessoJsp();
			acesso.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			acesso.setPrimeironome(primeironome);
			acesso.setSobrenome(sobrenome);
			acesso.setUltimonome(ultimonome);
			acesso.setUsuario(usuario);
			acesso.setSenha(senha);
			acesso.setTelefone(telefone);
			acesso.setEmail(email);
			
			if (request.getParameter("ativo") != null && request.getParameter("ativo").equalsIgnoreCase("on")) {
				acesso.setAtivo(true);
			} else {
				acesso.setAtivo(false);
			}
			
			acesso.setPerfil(perfil);
			
			
			String msg = null;
			boolean podeInserir = true;
			
			if (id == null || id.isEmpty() && !dao.validarUsuario(usuario)) {/*isso quando for usuário novo*/
				msg = "Já existe cadastro com este usuário!";
				podeInserir = false;
			} 
			
			/*quando for salvar ou atualizar*/
			if (id == null || id.isEmpty() && dao.validarUsuario(usuario) && podeInserir) {
				dao.salvarU(acesso);
				msg = "Registro salvo com sucesso!";
				
			} else if(id != null && !id.isEmpty() && podeInserir) {
				dao.updateU(acesso);
				msg = "Registro atualizado com sucesso!";
			}
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrousuarios.jsp");
			request.setAttribute("usuarios", dao.listarTodos());
			view.forward(request, response);
			
		}
	}

}

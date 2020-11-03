package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.Categoria;
import br.com.sysjsp.dao.CategoriaDao;

@WebServlet("/servletCategoria")
public class ServletCategoria extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	private CategoriaDao categoriaDao = new CategoriaDao();
       
    public ServletCategoria() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String categoria = request.getParameter("categoria");
		
		if (acao.equalsIgnoreCase("delete")) {
			categoriaDao.deleteEsp(categoria);
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrocategorias.jsp");
			request.setAttribute("categorias", categoriaDao.listarTodosCat());
			view.forward(request, response);
			
		} else
			
		if (acao.equalsIgnoreCase("update")) {
			Categoria cat = categoriaDao.consultarCat(categoria);
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrocategorias.jsp");
			request.setAttribute("categoria", cat);
			view.forward(request, response);
			
		} else
		
		if (acao.equalsIgnoreCase("listartodos")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrocategorias.jsp");
			request.setAttribute("categorias", categoriaDao.listarTodosCat());
			view.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrocategorias.jsp");
			request.setAttribute("categorias", categoriaDao.listarTodosCat());
			view.forward(request, response);
			
		} else {
			
			String id = request.getParameter("id");
			String descricao = request.getParameter("descricao");
			
			Categoria cat = new Categoria();
			cat.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			cat.setDescricao(descricao);
			
			String msg = null;
			boolean adicionar = true;
			
			if (descricao == null || descricao.isEmpty()) {
				msg = "Preencha o campo descrição!";
				adicionar = false;
			} else
				
			if (id == null || id.isEmpty() && !categoriaDao.validarDescricao(descricao)) {
				request.setAttribute("msg", "Esta especialidade já estar cadastrada no sistema!");
			}
			
			if (msg != null) {
				request.setAttribute("msg", msg);
			} else 
			
			if (id == null || id.isEmpty() && categoriaDao.validarDescricao(descricao) && adicionar) {
				categoriaDao.saveCat(cat);
				//request.setAttribute("msg", "Registro salvo com sucesso!");
			} else
				
			if (id != null || !id.isEmpty() && adicionar) {
				categoriaDao.updateEsp(cat);
				//request.setAttribute("msg", "Registro atualizado com sucesso!");
			}
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastrocategorias.jsp");
			request.setAttribute("categorias", categoriaDao.listarTodosCat());
			view.forward(request, response);
		}
	}

}

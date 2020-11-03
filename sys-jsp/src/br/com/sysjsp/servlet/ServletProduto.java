package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.Produto;
import br.com.sysjsp.dao.ProdutoDao;

@WebServlet("/ServletProduto")
public class ServletProduto extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ProdutoDao produtoDao = new ProdutoDao();
       
    public ServletProduto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String produto = request.getParameter("produto");
		
		/*linha que redireciona para a página*/
		RequestDispatcher view = request.getRequestDispatcher("/cadastroprodutos.jsp");
		
		if (acao.equalsIgnoreCase("delete")) {
			produtoDao.deleteP(produto);
			request.setAttribute("produtos", produtoDao.listarTodosP());
		} else
			
		if (acao.equalsIgnoreCase("update")) {
			Produto pro = produtoDao.consultarP(produto);
			request.setAttribute("produto", pro);
		} else
			
		if (acao.equalsIgnoreCase("listartodos")) {
			request.setAttribute("produtos", produtoDao.listarTodosP());
		}
		
		request.setAttribute("categorias", produtoDao.listarTodasCategorias());
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroprodutos.jsp");
			request.setAttribute("produtos", produtoDao.listarTodosP());
			view.forward(request, response);
			
		} else {
			
			String id = request.getParameter("id");
			String descricao = request.getParameter("descricao");
			String quantidade = request.getParameter("quantidade");
			String valorcompra = request.getParameter("valorcompra");
			String valoritem = request.getParameter("valoritem");
			String categoria = request.getParameter("id_categoria");
			
			Produto produto = new Produto();
			produto.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			produto.setDescricao(descricao);
			produto.setQuantidade(Integer.parseInt(quantidade));
			
			if (valorcompra != null && !valorcompra.isEmpty()) {
				String valorParseVC = valorcompra.replaceAll("\\.", "").replaceAll("\\,", ".");
				produto.setValorcompra(Double.valueOf(valorParseVC));
			}
			
			if (valoritem != null && !valoritem.isEmpty()) {
				String valorParseVI = valoritem.replaceAll("\\.", "").replaceAll("\\,", ".");
				produto.setValoritem(Double.valueOf(valorParseVI));
			}
			
			produto.setCategoria(Long.parseLong(categoria));
			
			String msg = null;
			boolean podeInserir = true;
			
			if (id == null || id.isEmpty() && !produtoDao.validarDescricaoP(descricao)) {
				msg = "Já existe um produto cadastro com essa descrição!";
				podeInserir = false;
			} 
				
			if (msg != null) {
				request.setAttribute("msg", msg);
			}
			
			if (id == null || id.isEmpty() && produtoDao.validarDescricaoP(descricao) && podeInserir) {
				
				produtoDao.saveP(produto);
				//request.setAttribute("msg", "Registro salvo com sucesso!");
				
			} else 
				
			if (id != null && !id.isEmpty() && podeInserir) {
				
				produtoDao.updateP(produto);
				//request.setAttribute("msg", "Registro atualizado com sucesso!");
				
			}
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroprodutos.jsp");
			request.setAttribute("produtos", produtoDao.listarTodosP());
			request.setAttribute("categorias", produtoDao.listarTodasCategorias());/*lista de categorias cadastradas no banco de dados*/
			view.forward(request, response);
			
		}
		
	}

}

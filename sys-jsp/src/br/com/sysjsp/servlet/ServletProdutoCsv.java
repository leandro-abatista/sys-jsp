package br.com.sysjsp.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.ProdutoCsv;
import br.com.sysjsp.dao.DaoProdutoCsv;

/**
 * Servlet implementation class ServletProdutoCsv
 */
@WebServlet("/ServletProdutoCsv")
public class ServletProdutoCsv extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoProdutoCsv daoProdutoCsv = new DaoProdutoCsv();
       
    public ServletProdutoCsv() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acao = request.getParameter("acao");
		String produtocsv = request.getParameter("produtocsv");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroprodutosCsv.jsp");
		
		if (acao != null && acao.equalsIgnoreCase("delete")) {
			daoProdutoCsv.delete(produtocsv);
			request.setAttribute("produtos", daoProdutoCsv.listarTodosProdutosCsv());
		} else
			
		if (acao != null && acao.equalsIgnoreCase("update")) {
			ProdutoCsv procsv = daoProdutoCsv.consultarProdutoCsv(produtocsv);
			request.setAttribute("produtocsv", procsv);
		} else
			
		if (acao != null && acao.equalsIgnoreCase("listartodos")) {
			request.setAttribute("produtos", daoProdutoCsv.listarTodosProdutosCsv());
		}
		
		request.setAttribute("bandeiras", daoProdutoCsv.listarTodasBandeiras());
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroprodutosCsv.jsp");
			request.setAttribute("produtos", daoProdutoCsv.listarTodosProdutosCsv());
			dispatcher.forward(request, response);
			
		} else {
			
			String id = request.getParameter("id");
			String revenda = request.getParameter("revenda");
			String cnpjRevenda = request.getParameter("cnpjRevenda");
			String descricaoProduto = request.getParameter("descricaoProduto");
			String dataColeta = request.getParameter("dataColeta");
			String valorCompra = request.getParameter("valorCompra");
			String valorVenda = request.getParameter("valorVenda");
			String quantidade = request.getParameter("quantidade");
			String unidadeMedida = request.getParameter("unidadeMedida");
			String tipo = request.getParameter("tipo");
			String estado = request.getParameter("estado");
			String cidade = request.getParameter("cidade");
			String id_bandeira = request.getParameter("id_bandeira");
			
			ProdutoCsv procsv = new ProdutoCsv();
			procsv.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			procsv.setRevenda(revenda);
			procsv.setCnpjRevenda(cnpjRevenda);
			procsv.setDescricaoProduto(descricaoProduto);
			procsv.setDataColeta(dataColeta);
			
			if (valorCompra != null && !valorCompra.isEmpty()) {
				String valorParseVC = valorCompra.replaceAll("\\.", "").replaceAll("\\,", ".");
				procsv.setValorCompra(Double.valueOf(valorParseVC));
			}
			
			if (valorVenda != null && !valorVenda.isEmpty()) {
				String valorParseVV = valorVenda.replaceAll("\\.", "").replaceAll("\\,", ".");
				procsv.setValorVenda(Double.valueOf(valorParseVV));
			}
			
			procsv.setQuantidade(Integer.parseInt(quantidade));
			procsv.setUnidadeMedida(unidadeMedida);
			procsv.setTipo(tipo);
			procsv.setEstado(estado);
			procsv.setCidade(cidade);
			procsv.setId_bandeira(Long.parseLong(id_bandeira));
			
			String msg = null;
			boolean podeAdicionar = true;
			
			if (msg != null) {
				request.setAttribute("msg", msg);
			}
			
			if (id == null || id.isEmpty() && podeAdicionar) {
				daoProdutoCsv.save(procsv);
			} else
				
			if (id != null || !id.isEmpty() && podeAdicionar) {
				daoProdutoCsv.update(procsv);
			}
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroprodutosCsv.jsp");
			request.setAttribute("produtos", daoProdutoCsv.listarTodosProdutosCsv());
			request.setAttribute("bandeiras", daoProdutoCsv.listarTodasBandeiras());
			dispatcher.forward(request, response);
		}
	}

}

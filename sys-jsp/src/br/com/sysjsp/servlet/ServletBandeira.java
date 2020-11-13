package br.com.sysjsp.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.Bandeira;
import br.com.sysjsp.classes.model.ProdutoCsv;
import br.com.sysjsp.dao.DaoBandeira;

/**
 * Servlet implementation class ServletBandeira
 */
@WebServlet("/ServletBandeira")
public class ServletBandeira extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DaoBandeira daoBandeira = new DaoBandeira();
       
    public ServletBandeira() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String band = request.getParameter("band");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrobandeiras.jsp");
		
		if (acao != null && acao.equalsIgnoreCase("delete")) {
			daoBandeira.delete(band);
			request.setAttribute("bandeiras", daoBandeira.listarTodasBandeiras());
		} else
			
		if (acao != null && acao.equalsIgnoreCase("update")) {
			Bandeira bandeira = daoBandeira.consultarBandeira(band);
			request.setAttribute("band", bandeira);
		} else
			
		if (acao != null && acao.equalsIgnoreCase("listartodos")) {
			request.setAttribute("bandeiras", daoBandeira.listarTodasBandeiras());
		}
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrobandeiras.jsp");
			request.setAttribute("bandeiras", daoBandeira.listarTodasBandeiras());
			dispatcher.forward(request, response);
			
		} else {
			
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			
			Bandeira bandeira = new Bandeira();
			bandeira.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			bandeira.setNome(nome);
			
			String msg = null;
			boolean podeAdicionar = true;
			
			if (id == null || id.isEmpty() && !daoBandeira.validarNome(nome)) {
				msg = "Já existe um registro cadastrado com este nome!";
				podeAdicionar = false;
			}
			
			if (msg != null) {
				request.setAttribute("msg", msg);
			}
			
			if (id == null || id.isEmpty() && daoBandeira.validarNome(nome) && podeAdicionar) {
				daoBandeira.save(bandeira);
			} else
				
			if (id != null || !id.isEmpty() && podeAdicionar) {
				daoBandeira.update(bandeira);
			}
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrobandeiras.jsp");
			request.setAttribute("bandeiras", daoBandeira.listarTodasBandeiras());
			dispatcher.forward(request, response);
		}
	}

}

package br.com.sysjsp.filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.sysjsp.classes.model.AcessoJsp;
import br.com.sysjsp.connect.SingleConnection;

@WebFilter(urlPatterns = {"/*"})
public class Filter implements javax.servlet.Filter{
	
	private  static Connection connection;
	
	@Override
	public void destroy() {
		
	}
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest http = (HttpServletRequest) request;
		HttpSession session = http.getSession();
		
		String urlDeAutenticacao = http.getServletPath();
		AcessoJsp acesso = (AcessoJsp) session.getAttribute("usuar");
		
		if (acesso == null && !urlDeAutenticacao.equalsIgnoreCase("ServletLogin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp?url=" + urlDeAutenticacao);
			dispatcher.forward(request, response);
			return;//para o processo para redirecionar
		}
		
		/**
		 * Executa as ações de request e response
		 */
		chain.doFilter(request, response);
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}

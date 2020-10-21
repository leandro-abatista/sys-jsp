package br.com.sysjsp.filter;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.sysjsp.connect.SingleConnection;

@WebFilter(urlPatterns = {"/*"})
public class Filter implements javax.servlet.Filter{
	
	private  static Connection connection;
	
	@Override
	public void destroy() {
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		connection = SingleConnection.getConnection();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			
			chain.doFilter(request, response);
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				
				connection.rollback();
				
			} catch (Exception ex) {
				ex.printStackTrace();
				
			}
		}
		
	}

}

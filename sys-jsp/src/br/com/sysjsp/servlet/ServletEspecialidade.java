package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.Especialidade;
import br.com.sysjsp.dao.EspecialidadeDao;

@WebServlet("/ServletEspecialidade")
public class ServletEspecialidade extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private EspecialidadeDao especialidadeDao = new EspecialidadeDao();
       
    public ServletEspecialidade() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String especialidade = request.getParameter("especialidade");
		
		if (acao.equalsIgnoreCase("delete")) {
			especialidadeDao.deleteEsp(especialidade);
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroespecialidades.jsp");
			request.setAttribute("especialidades", especialidadeDao.listarTodosEsp());
			view.forward(request, response);
			
		} else
			
		if (acao.equalsIgnoreCase("update")) {
			Especialidade epc = especialidadeDao.consultarEsp(especialidade);
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroespecialidades.jsp");
			request.setAttribute("especialidade", epc);
			view.forward(request, response);
			
		} else
		
		if (acao.equalsIgnoreCase("listartodos")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroespecialidades.jsp");
			request.setAttribute("especialidades", especialidadeDao.listarTodosEsp());
			view.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroespecialidades.jsp");
			request.setAttribute("especialidades", especialidadeDao.listarTodosEsp());
			view.forward(request, response);
			
		} else {
			
			String id = request.getParameter("id");
			String descricao = request.getParameter("descricao");
			
			Especialidade esp = new Especialidade();
			esp.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			esp.setDescricao(descricao);
			
			String msg = null;
			boolean adicionar = true;
			
			if (descricao == null || descricao.isEmpty()) {
				msg = "Preencha o campo descrição!";
				adicionar = false;
			} else
				
			if (id == null || id.isEmpty() && !especialidadeDao.validarDescricao(descricao)) {
				request.setAttribute("msg", "Esta especialidade já estar cadastrada no sistema!");
			}
			
			if (msg != null) {
				request.setAttribute("msg", msg);
			} else 
			
			if (id == null || id.isEmpty() && especialidadeDao.validarDescricao(descricao) && adicionar) {
				especialidadeDao.saveEsp(esp);
				//request.setAttribute("msg", "Registro salvo com sucesso!");
			} else
				
			if (id != null || !id.isEmpty() && adicionar) {
				especialidadeDao.updateEsp(esp);
				//request.setAttribute("msg", "Registro atualizado com sucesso!");
			}
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroespecialidades.jsp");
			request.setAttribute("especialidades", especialidadeDao.listarTodosEsp());
			view.forward(request, response);
		}
	}

}

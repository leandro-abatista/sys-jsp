package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.Medico;
import br.com.sysjsp.dao.MedicoDao;

@WebServlet("/ServletMedico")
public class ServletMedico extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private MedicoDao dao = new MedicoDao();
       
    public ServletMedico() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String med = request.getParameter("med");
		
		/*linha que redireciona para a página*/
		RequestDispatcher view = request.getRequestDispatcher("/cadastromedicos.jsp");
		
		if (acao != null && acao.equalsIgnoreCase("delete") && med != null) {
			
			dao.deleteM(med);
			request.setAttribute("medicos", dao.listarTodosM());
			
		} else
			
		if (acao != null && acao.equalsIgnoreCase("update")) {
			
			Medico medico = dao.consultarM(med);
			request.setAttribute("med", medico);
			
		} else
			
		if (acao != null && acao.equalsIgnoreCase("listartodos")) {
			
			request.setAttribute("medicos", dao.listarTodosM());
		}
		
		request.setAttribute("especialidades", dao.listarTodasEspecialidades());
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastromedicos.jsp");
			request.setAttribute("medicos", dao.listarTodosM());
			view.forward(request, response);
			
		} else {
			
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String crm = request.getParameter("crm");
			String uf = request.getParameter("uf");
			String email = request.getParameter("email");
			String datacadastro = request.getParameter("datacadastro");
			String datanascimento = request.getParameter("datanascimento");
			String genero = request.getParameter("genero");

			String cep = request.getParameter("cep");
			String endereco = request.getParameter("endereco");
			String numero = request.getParameter("numero");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String ibge = request.getParameter("ibge");
			String especialidade = request.getParameter("id_especialidade");
			

			Medico medico = new Medico();
			medico.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			medico.setNome(nome);
			medico.setCpf(cpf);
			medico.setCrm(crm);
			medico.setUf(uf);
			medico.setEmail(email);
			medico.setDataCadastro(datacadastro);
			medico.setDataNascimento(datanascimento);
			medico.setGenero(genero);
			
			medico.setCep(cep);
			medico.setEndereco(endereco);
			medico.setNumero(Integer.parseInt(numero));
			medico.setBairro(bairro);
			medico.setCidade(cidade);
			medico.setEstado(estado);
			medico.setIbge(Integer.parseInt(ibge));
			medico.setEspecialidade(Long.parseLong(especialidade));
			
			
			String msg = null;
			boolean adicionar = true;
			
			/*Início do código da validação por nome, cpf e crm*/
			if (nome == null || nome.isEmpty() && !dao.validarPeloNomeMed(nome)) {
				msg = "Já existe um médico cadastrado com este nome! Por favor insira um nome válido.";
				adicionar = false;
			} else
				
			if (cpf == null || cpf.isEmpty() && !dao.validarPeloCpfMed(cpf)) {
				msg = "Já existe um médico cadastrado com este CPF! Por favor insira um CPF válido.";
				adicionar = false;
			} else
				
			if (crm == null || crm.isEmpty() && !dao.validarPeloCrmMed(crm)) {
				msg = "Já existe um médico cadastrado com este CRM! Por favor insira um CRM válido.";
				adicionar = false;
			}
			/*Fim do código da validação por nome, cpf e crm*/
			
			if (msg != null) {
				request.setAttribute("msg", msg);
			} else
				
			if (id == null || id.isEmpty() && dao.validarPeloNomeMed(nome) && adicionar) {
				dao.saveM(medico);
			} else
				
			if (id != null || !id.isEmpty() && dao.validarPeloNomeMed(nome) && adicionar) {
				dao.updateM(medico);
			}
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastromedicos.jsp");
			request.setAttribute("medicos", dao.listarTodosM());
			request.setAttribute("especialidades", dao.listarTodasEspecialidades());
			view.forward(request, response);
		}
	}

}

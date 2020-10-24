package br.com.sysjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sysjsp.classes.model.Cliente;
import br.com.sysjsp.dao.ClienteDao;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ClienteDao clienteDao = new ClienteDao();
   
    public ServletCliente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		String cli = request.getParameter("cli");
		String msg = null;
		
		
		if (acao.equalsIgnoreCase("delete")) {
			
			clienteDao.deleteC(cli);
			msg = "Registro excluído com sucesso!";
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroclientes.jsp");
			request.setAttribute("clientes", clienteDao.listarTodos());
			view.forward(request, response);
			
		} else
			
		if (acao.equalsIgnoreCase("update")) {
			
			Cliente cliente = clienteDao.consultaC(cli);
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroclientes.jsp");
			request.setAttribute("cli", cliente);
			view.forward(request, response);
			
		} else
			
		if (acao.equalsIgnoreCase("listartodos")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroclientes.jsp");
			request.setAttribute("clientes", clienteDao.listarTodos());
			view.forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null && acao.equalsIgnoreCase("reset")) {
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroclientes.jsp");
			request.setAttribute("clientes", clienteDao.listarTodos());
			view.forward(request, response);
			
		} else {
			
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String rg = request.getParameter("rg");
			String orgaoexpeditor = request.getParameter("orgaoexpeditor");
			String datanascimento = request.getParameter("datanascimento");
			String telefonefixo = request.getParameter("telefonefixo");
			String telefonecelular = request.getParameter("telefonecelular");
			String email = request.getParameter("email");
			String observacao = request.getParameter("observacao");
			
			Cliente cliente = new Cliente();
			cliente.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			cliente.setNome(nome);
			cliente.setCpf(cpf);
			cliente.setRg(rg);
			cliente.setOrgaoexpeditor(orgaoexpeditor);
			cliente.setDatanascimento(datanascimento);
			cliente.setTelefonefixo(telefonefixo);
			cliente.setTelefonecelular(telefonecelular);
			cliente.setEmail(email);
			cliente.setObservacao(observacao);
			
			String msg = null;
			boolean podeInserir = true;
			
			/*validação de nome e cpf*/
			if (id == null || id.isEmpty() && !clienteDao.validarNomeCli(nome)) {
				msg = "Já existe um cliente cadastrado com este nome!";
				podeInserir = false;
			} else
			
			if(id == null || id.isEmpty() && !clienteDao.validarCpfCli(cpf)) {
				msg = "CPF já está cadastro para outro cliente. Por favor insira um CPF válido!";
				podeInserir = false;
			}
			
			/*verificando a mensagem se é nula ou não*/
			if (msg != null) {
				request.setAttribute("msg", msg);
			}
			
			if (id == null || id.isEmpty() && clienteDao.validarCpfCli(cpf) && podeInserir) {
				
				clienteDao.salvarC(cliente);
				msg = "Registro salvo com sucesso!";
				
			} else
				
			if (id != null || !id.isEmpty() && podeInserir) {
				
				clienteDao.updateC(cliente);
				msg = "Registro atualizado com sucesso!";
				
			}
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroclientes.jsp");
			request.setAttribute("clientes", clienteDao.listarTodos());
			view.forward(request, response);
			
		}
	}

}

package br.com.sysjsp.servlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.codec.binary.Base64;

import br.com.sysjsp.classes.model.Cliente;
import br.com.sysjsp.dao.ClienteDao;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
@MultipartConfig
public class ServletCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ClienteDao clienteDao = new ClienteDao();

	public ServletCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String cli = request.getParameter("cli");

		if (acao.equalsIgnoreCase("delete")) {

			clienteDao.deleteC(cli);

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

		} else 
			
		if (acao.equalsIgnoreCase("download")) {
			
			Cliente cliente = clienteDao.consultaC(cli);
			
			if (cliente != null) {
				/*setando a resposta*/
				response.setHeader("Content-Disposition", "attachment;filename=arquivo." + cliente.getContentType().split("\\/")[1]);
				
				/*converte a base64 da imagem do banco para byte[]*/
				byte[] imagemFotoBytes = new Base64().decodeBase64(cliente.getFotoBase64());
				
				/*coloca os bytes em um objeto de entrada para processar*/
				InputStream inputStream = new ByteArrayInputStream(imagemFotoBytes);
				
				/*início da resposta para o navegador*/
				int read = 0;
				byte[] bytes = new byte[1024];
				OutputStream outputStream = response.getOutputStream();
				
				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				
				outputStream.flush();
				outputStream.close();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

			String cep = request.getParameter("cep");
			String endereco = request.getParameter("endereco");
			String numero = request.getParameter("numero");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String ibge = request.getParameter("ibge");

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

			cliente.setCep(cep);
			cliente.setEndereco(endereco);
			cliente.setNumero(Integer.valueOf(numero));
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			cliente.setEstado(estado);
			cliente.setIbge(Integer.valueOf(ibge));

			try {
				/* Início do código - File upload de imagens e pdf */

				/* primeiro temos que validar, se o formulário, é um form de upload */
				if (ServletFileUpload.isMultipartContent(request)) {

					Part imagemFoto = request.getPart("foto");
					String fotoBase64 = new Base64().encodeBase64String(converteStreamParaByte(imagemFoto.getInputStream()));
					cliente.setFotoBase64(fotoBase64);
					cliente.setContentType(imagemFoto.getContentType());
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			/* Fim do código - - File upload de imagens e pdf */

			String msg = null;
			boolean podeInserir = true;

			/* validação de nome e cpf */
			if (id == null || id.isEmpty() && !clienteDao.validarNomeCli(nome)) {
				msg = "Já existe um cliente cadastrado com este nome!";
				podeInserir = false;
			} else

			if (id == null || id.isEmpty() && !clienteDao.validarCpfCli(cpf)) {
				msg = "CPF já está cadastro para outro cliente. Por favor insira um CPF válido!";
				podeInserir = false;
			}

			/* verificando a mensagem se é nula ou não */
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

	/*Converte a entrada de fluxo de dados da imagem para um array de byte[]*/
	private byte[] converteStreamParaByte(InputStream imagem) {
		try {
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			int reads;
			reads = imagem.read();

			/* enquanto tiver dados */
			while (reads != -1) {
				byteArrayOutputStream.write(reads);
				reads = imagem.read();
			}

			return byteArrayOutputStream.toByteArray();/* retorna um array de bytes */

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

package br.com.sysjsp.servlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import br.com.sysjsp.classes.model.Cliente;
import br.com.sysjsp.dao.ClienteDao;

@WebServlet("/ServletConsCli")
public class ServletConsCli extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ClienteDao clienteDao = new ClienteDao();

	public ServletConsCli() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String cli = request.getParameter("cli");

		if (acao.equalsIgnoreCase("listartodos")) {

			RequestDispatcher view = request.getRequestDispatcher("/consultaclientes.jsp");
			request.setAttribute("clientes", clienteDao.listarTodos());
			view.forward(request, response);

		} else

		if (acao.equalsIgnoreCase("download")) {

			Cliente cliente = clienteDao.consultaC(cli);

			if (cliente != null) {

				String contentType = "";
				byte[] fileBytes = null;
				String tipo = request.getParameter("tipo");

				if (tipo.equalsIgnoreCase("imagem")) {

					contentType = cliente.getContentType();
					/* converte a base64 da imagem do banco para byte[] */
					fileBytes = new Base64().decodeBase64(cliente.getFotoBase64());

				} else

				if (tipo.equalsIgnoreCase("arquivoEmPdf")) {

					contentType = cliente.getContentTypeArquivo();
					/* converte a base64 da imagem do banco para byte[] */
					fileBytes = new Base64().decodeBase64(cliente.getArquivoBase64());

				}

				/* setando a resposta */
				response.setHeader("Content-Disposition", "attachment;filename=arquivo." + contentType.split("\\/")[1]);

				/* coloca os bytes em um objeto de entrada para processar */
				InputStream inputStream = new ByteArrayInputStream(fileBytes);

				/* início da resposta para o navegador */
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && acao.equalsIgnoreCase("reset")) {

			RequestDispatcher view = request.getRequestDispatcher("/consultaclientes.jsp");
			request.setAttribute("clientes", clienteDao.listarTodos());
			view.forward(request, response);

		}
	}
	
	/* Converte a entrada de fluxo de dados da imagem para um array de byte[] */
	public static byte[] converteStreamParaByte(InputStream imagem) {
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

package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.Cliente;
import br.com.sysjsp.connect.SingleConnection;

public class ClienteDao {
	
	private Connection connection;
	
	public ClienteDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvarC(Cliente cliente) {
		try {
			
			String sql = "INSERT INTO tbl_cliente(" + 
					"            nome, cpf, rg, orgaoexpeditor, datanascimento, telefonefixo, " + 
					"            telefonecelular, email, observacao, cep, endereco, numero, bairro, " + 
					"            cidade, estado, ibge, genero, fotobase64, contenttype, arquivopdfbase64, " + 
					"            contenttypepdfarquivo, fotobase64miniatura) " + 
					"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, cliente.getNome());
			insert.setString(2, cliente.getCpf());
			insert.setString(3, cliente.getRg());
			insert.setString(4, cliente.getOrgaoexpeditor());
			insert.setString(5, cliente.getDatanascimento());
			insert.setString(6, cliente.getTelefonefixo());
			insert.setString(7, cliente.getTelefonecelular());
			insert.setString(8, cliente.getEmail());
			insert.setString(9, cliente.getObservacao());
			insert.setString(10, cliente.getCep());
			insert.setString(11, cliente.getEndereco());
			insert.setInt(12, cliente.getNumero());
			insert.setString(13, cliente.getBairro());
			insert.setString(14, cliente.getCidade());
			insert.setString(15, cliente.getEstado());
			insert.setInt(16, cliente.getIbge());
			insert.setString(17, cliente.getGenero());
			//insert imagem
			insert.setString(18, cliente.getFotoBase64());
			insert.setString(19, cliente.getContentType());
			//insert pdf
			insert.setString(20, cliente.getArquivoBase64());
			insert.setString(21, cliente.getContentTypeArquivo());
			//miniatura
			insert.setString(22, cliente.getFotoBase64Miniatura());
			
			insert.execute();
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
	
	public List<Cliente> listarTodos(){
		try {
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			String sql = "SELECT * FROM tbl_cliente order by id;";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();
			
			while (rs.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setRg(rs.getString("rg"));
				cliente.setOrgaoexpeditor(rs.getString("orgaoexpeditor"));
				cliente.setDatanascimento(rs.getString("datanascimento"));
				cliente.setTelefonefixo(rs.getString("telefonefixo"));
				cliente.setTelefonecelular(rs.getString("telefonecelular"));
				cliente.setEmail(rs.getString("email"));
				cliente.setObservacao(rs.getString("observacao"));
				cliente.setCep(rs.getString("cep"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNumero(rs.getInt("numero"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setIbge(rs.getInt("ibge"));
				cliente.setGenero(rs.getString("genero"));
				//cliente.setFotoBase64(rs.getString("fotobase64"));
				cliente.setContentType(rs.getString("contenttype"));
				cliente.setArquivoBase64(rs.getString("arquivopdfbase64"));
				cliente.setContentTypeArquivo(rs.getString("contenttypepdfarquivo"));
				cliente.setFotoBase64Miniatura(rs.getString("fotobase64miniatura"));
				
				clientes.add(cliente);
			}
			
			return clientes;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Cliente consultaC(String id) {
		try {
			
			String sql = "SELECT * FROM tbl_cliente WHERE id = '" + id + "'";
			PreparedStatement consultar = connection.prepareStatement(sql);
			ResultSet rs = consultar.executeQuery();
			
			if (rs.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setRg(rs.getString("rg"));
				cliente.setOrgaoexpeditor(rs.getString("orgaoexpeditor"));
				cliente.setDatanascimento(rs.getString("datanascimento"));
				cliente.setTelefonefixo(rs.getString("telefonefixo"));
				cliente.setTelefonecelular(rs.getString("telefonecelular"));
				cliente.setEmail(rs.getString("email"));
				cliente.setObservacao(rs.getString("observacao"));
				cliente.setCep(rs.getString("cep"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNumero(rs.getInt("numero"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setIbge(rs.getInt("ibge"));
				cliente.setGenero(rs.getString("genero"));
				cliente.setFotoBase64(rs.getString("fotobase64"));
				cliente.setContentType(rs.getString("contenttype"));
				cliente.setArquivoBase64(rs.getString("arquivopdfbase64"));
				cliente.setContentTypeArquivo(rs.getString("contenttypepdfarquivo"));
				cliente.setFotoBase64Miniatura(rs.getString("fotobase64miniatura"));
				
				return cliente;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateC(Cliente cliente) {
		try {
			
			StringBuilder sql = new StringBuilder();

			sql.append("UPDATE tbl_cliente SET id=?, nome=?, cpf=?, rg=?, orgaoexpeditor=?, datanascimento=?, telefonefixo=?, telefonecelular=?, ");
			sql.append(" email=?, observacao=?, cep=?, endereco=?, numero=?, bairro=?, cidade=?, estado=?, ibge=?, genero=? ");

			if (cliente.isAtualizarImagem()) {
				sql.append(",	             fotobase64=?, contenttype=? ");
			}

			if (cliente.isAtualizarPdf()) {
				sql.append(",                 contenttypepdfarquivo=?, arquivopdfbase64=? ");
			}

			if (cliente.isAtualizarImagem()) {
				sql.append(",					  fotobase64miniatura=? ");
			}

			sql.append(" 	WHERE id = '" + cliente.getId() + "'");

			PreparedStatement update = connection.prepareStatement(sql.toString());
			update.setLong(1, cliente.getId());
			update.setString(2, cliente.getNome());
			update.setString(3, cliente.getCpf());
			update.setString(4, cliente.getRg());
			update.setString(5, cliente.getOrgaoexpeditor());
			update.setString(6, cliente.getDatanascimento());
			update.setString(7, cliente.getTelefonefixo());
			update.setString(8, cliente.getTelefonecelular());
			update.setString(9, cliente.getEmail());
			update.setString(10, cliente.getObservacao());
			update.setString(11, cliente.getCep());
			update.setString(12, cliente.getEndereco());
			update.setInt(13, cliente.getNumero());
			update.setString(14, cliente.getBairro());
			update.setString(15, cliente.getCidade());
			update.setString(16, cliente.getEstado());
			update.setInt(17, cliente.getIbge());
			update.setString(18, cliente.getGenero());

			if (cliente.isAtualizarImagem()) {
				update.setString(19, cliente.getFotoBase64());
				update.setString(20, cliente.getContentType());
			}

			if (cliente.isAtualizarPdf()) {
				
				if (cliente.isAtualizarPdf() && !cliente.isAtualizarImagem()) {
					update.setString(19, cliente.getArquivoBase64());
					update.setString(20, cliente.getContentTypeArquivo());
				} else {
					update.setString(21, cliente.getArquivoBase64());
					update.setString(22, cliente.getContentTypeArquivo());
				}
				
			} else {
				if (cliente.isAtualizarImagem()) {
					update.setString(21, cliente.getFotoBase64Miniatura());
				}
			}

			if (cliente.isAtualizarImagem() && cliente.isAtualizarPdf()) {
				update.setString(23, cliente.getFotoBase64Miniatura());
			}

			update.executeUpdate();
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
	
	public void deleteC(String id) {
		try {
			
			String sql = "DELETE FROM tbl_cliente WHERE id = '" + id + "'";
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();
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
	
	public boolean validarNomeCli(String nome) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_cliente WHERE nome = '" + nome + "'";
			PreparedStatement validar = connection.prepareStatement(sql);
			ResultSet rs = validar.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;/*se for menor ou igual a 0 -> retorna true, se não é false*/
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validarCpfCli(String cpf) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_cliente WHERE cpf = '" + cpf + "'";
			PreparedStatement validar = connection.prepareStatement(sql);
			ResultSet rs = validar.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;/*se for menor ou igual a 0 -> retorna true, se não é false*/
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

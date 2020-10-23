package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.Date;
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
					"            telefonecelular, email, observacao)" + 
					"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, cliente.getNome());
			insert.setString(2, cliente.getCpf());
			insert.setString(3, cliente.getRg());
			insert.setString(4, cliente.getOrgaoexpeditor());
			insert.setDate(5, (Date) cliente.getDatanascimento());
			insert.setString(6, cliente.getTelefonefixo());
			insert.setString(7, cliente.getTelefonecelular());
			insert.setString(8, cliente.getEmail());
			insert.setString(9, cliente.getObservacao());
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
			
			String sql = "SELECT * FROM tbl_cliente;";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();
			
			while (rs.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setRg(rs.getString("rg"));
				cliente.setOrgaoexpeditor(rs.getString("orgaoexpeditor"));
				cliente.setDatanascimento(rs.getDate("datanascimento"));
				cliente.setTelefonefixo(rs.getString("telefonefixo"));
				cliente.setTelefonecelular(rs.getString("telefonecelular"));
				cliente.setEmail(rs.getString("email"));
				cliente.setObservacao(rs.getString("observacao"));
				
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
			
			String sql = "SELECT * FROM tbl_cliente WHERE id = " + id;
			PreparedStatement consultar = connection.prepareStatement(sql);
			ResultSet rs = consultar.executeQuery();
			
			if (rs.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setRg(rs.getString("rg"));
				cliente.setOrgaoexpeditor(rs.getString("orgaoexpeditor"));
				cliente.setDatanascimento(rs.getDate("datanascimento"));
				cliente.setTelefonefixo(rs.getString("telefonefixo"));
				cliente.setTelefonecelular(rs.getString("telefonecelular"));
				cliente.setEmail(rs.getString("email"));
				cliente.setObservacao(rs.getString("observacao"));
				
				return cliente;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateC(Cliente cliente) {
		try {
			
			String sql = "UPDATE tbl_cliente" + 
					"   SET id=?, nome=?, cpf=?, rg=?, orgaoexpeditor=?, datanascimento=?, " + 
					"       telefonefixo=?, telefonecelular=?, email=?, observacao=?\r\n" + 
					" WHERE cliente = " + cliente.getId();
			PreparedStatement update = connection.prepareStatement(sql);
			update.setString(1, cliente.getNome());
			update.setString(2, cliente.getCpf());
			update.setString(3, cliente.getRg());
			update.setString(4, cliente.getOrgaoexpeditor());
			update.setDate(5, (Date) cliente.getDatanascimento());
			update.setString(6, cliente.getTelefonefixo());
			update.setString(7, cliente.getTelefonecelular());
			update.setString(8, cliente.getEmail());
			update.setString(9, cliente.getObservacao());
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
			
			String sql = "DELETE FROM tbl_cliente WHERE id = " + id;
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.executeQuery();
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
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_cliente WHERE nome = " + nome;
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
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_cliente WHERE cpf = " + cpf;
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

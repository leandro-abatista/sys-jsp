package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.Medico;
import br.com.sysjsp.connect.SingleConnection;

public class MedicoDao {
	
	private Connection connection;
	
	public MedicoDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void saveM(Medico medico) {
		try {
			
			String sql = "INSERT INTO tbl_medico(" + 
					"            nome, cpf, crm, uf, especialidade, email, datacadastro, cep, " + 
					"            endereco, numero, bairro, cidade, estado, ibge) " + 
					"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, medico.getNome());
			insert.setString(2, medico.getCpf());
			insert.setString(3, medico.getCrm());
			insert.setString(4, medico.getUf());
			insert.setString(5, medico.getEspecialidade());
			insert.setString(6, medico.getEmail());
			insert.setDate(7, medico.getDataCadastro());
			insert.setString(8, medico.getCep());
			insert.setString(9, medico.getEndereco());
			insert.setInt(10, medico.getNumero());
			insert.setString(11, medico.getBairro());
			insert.setString(12, medico.getCidade());
			insert.setString(13, medico.getEstado());
			insert.setInt(14, medico.getIbge());
			
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
	
	public List<Medico> listarTodosM(){
		try {
			
			List<Medico> medicos = new ArrayList<Medico>();
			
			String sql = "SELECT * FROM tbl_medico order by id;";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();
			
			while (rs.next()) {
				
				Medico medico = new Medico();
				medico.setId(rs.getLong("id"));
				medico.setNome(rs.getString("nome"));
				medico.setCpf(rs.getString("cpf"));
				medico.setCrm(rs.getString("crm"));
				medico.setUf(rs.getString("uf"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medico.setEmail(rs.getString("email"));
				medico.setDataCadastro(rs.getDate("datacadastro"));
				medico.setCep(rs.getString("cep"));
				medico.setEndereco(rs.getString("endereco"));
				medico.setNumero(rs.getInt("numero"));
				medico.setBairro(rs.getString("bairro"));
				medico.setCidade(rs.getString("cidade"));
				medico.setEstado(rs.getString("estado"));
				medico.setIbge(rs.getInt("ibge"));
				
				medicos.add(medico);
			}
			
			return medicos;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Medico consultarM(String id) {
		try {
			
			String sql = "SELECT * FROM tbl_medico order by id = '" + id + "'";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();
			
			while (rs.next()) {
				
				Medico medico = new Medico();
				medico.setId(rs.getLong("id"));
				medico.setNome(rs.getString("nome"));
				medico.setCpf(rs.getString("cpf"));
				medico.setCrm(rs.getString("crm"));
				medico.setUf(rs.getString("uf"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medico.setEmail(rs.getString("email"));
				medico.setDataCadastro(rs.getDate("datacadastro"));
				medico.setCep(rs.getString("cep"));
				medico.setEndereco(rs.getString("endereco"));
				medico.setNumero(rs.getInt("numero"));
				medico.setBairro(rs.getString("bairro"));
				medico.setCidade(rs.getString("cidade"));
				medico.setEstado(rs.getString("estado"));
				medico.setIbge(rs.getInt("ibge"));
				
				return medico;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateM(Medico medico) {
try {
			
			String sql = "UPDATE tbl_medico " + 
					"   SET id=?, nome=?, cpf=?, crm=?, uf=?, especialidade=?, email=?, datacadastro=?, " + 
					"       cep=?, endereco=?, numero=?, bairro=?, cidade=?, estado=?, ibge=? " + 
					" WHERE id = '" + medico.getId() + "'";
			PreparedStatement update = connection.prepareStatement(sql);
			update.setLong(1, medico.getId());
			update.setString(2, medico.getNome());
			update.setString(3, medico.getCpf());
			update.setString(4, medico.getCrm());
			update.setString(5, medico.getUf());
			update.setString(6, medico.getEspecialidade());
			update.setString(7, medico.getEmail());
			update.setDate(8, medico.getDataCadastro());
			update.setString(9, medico.getCep());
			update.setString(10, medico.getEndereco());
			update.setInt(11, medico.getNumero());
			update.setString(12, medico.getBairro());
			update.setString(13, medico.getCidade());
			update.setString(14, medico.getEstado());
			update.setInt(15, medico.getIbge());
			
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
	
	public void deleteM(String id) {
		try {
			
			String sql = "DELETE FROM tbl_medico WHERE id = '" + id + "'";
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
	
	public boolean validarPeloNomeMed(String nome) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_medico WHERE nome = '" + nome + "'";
			PreparedStatement validar = connection.prepareStatement(sql);
			ResultSet rs = validar.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validarPeloCpfMed(String cpf) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_medico WHERE cpf = '" + cpf + "'";
			PreparedStatement validar = connection.prepareStatement(sql);
			ResultSet rs = validar.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validarPeloCrmMed(String crm) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_medico WHERE crm = '" + crm + "'";
			PreparedStatement validar = connection.prepareStatement(sql);
			ResultSet rs = validar.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("qtd") <= 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}

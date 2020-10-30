package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.Especialidade;
import br.com.sysjsp.connect.SingleConnection;

public class EspecialidadeDao {
	
	private Connection connection;
	
	public EspecialidadeDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void saveEsp(Especialidade especialidade) {
		try {
			
			String sql = "INSERT INTO tbl_especialidade (descricao) VALUES (?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, especialidade.getDescricao());
			
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
	
	public List<Especialidade> listarTodosEsp(){
		try {
			
			List<Especialidade> especialidades = new ArrayList<Especialidade>();
			
			String sql = "SELECT * FROM tbl_especialidade order by id;";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();
			
			while (rs.next()) {
				
				Especialidade especialidade = new Especialidade();
				especialidade.setId(rs.getLong("id"));
				especialidade.setDescricao(rs.getString("descricao"));
				
				especialidades.add(especialidade);
			}
			
			return especialidades;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Especialidade consultarEsp(String id) {
		try {
			
			String sql = "SELECT * FROM tbl_especialidade order by id = '" + id + "'";
			PreparedStatement consultar = connection.prepareStatement(sql);
			ResultSet rs = consultar.executeQuery();
			
			while (rs.next()) {
				
				Especialidade especialidade = new Especialidade();
				especialidade.setId(rs.getLong("id"));
				especialidade.setDescricao(rs.getString("descricao"));
				
				return especialidade;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateEsp(Especialidade especialidade) {
		try {
			
			String sql = "UPDATE tbl_especialidade SET id=?, descricao=? WHERE id = '" + especialidade.getId() + "'";
			PreparedStatement update = connection.prepareStatement(sql);
			update.setLong(1, especialidade.getId());
			update.setString(2, especialidade.getDescricao());
			
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
	
	public void deleteEsp(String id) {
		try {
			
			String sql = "DELETE FROM tbl_especialidade WHERE  id = '" + id + "'";
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
	
	public boolean validarDescricao(String descricao) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_especialidade WHERE descricao = '" + descricao + "'";
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

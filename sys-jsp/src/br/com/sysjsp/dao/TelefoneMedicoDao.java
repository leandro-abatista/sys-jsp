package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.TelefoneMedico;
import br.com.sysjsp.connect.SingleConnection;

public class TelefoneMedicoDao {
	
	private Connection connection;
	
	public TelefoneMedicoDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void saveTM(TelefoneMedico tm) {
		try {
			
			String sql = "INSERT INTO tbl_telefone_medico(numero, tipo, id_medico) VALUES (?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, tm.getNumero());
			statement.setString(2, tm.getNumero());
			statement.setLong(3, tm.getMedico());
			
			statement.execute();
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
	
	public List<TelefoneMedico> listarTodosTM(Long idMedico){
		try {
			
			List<TelefoneMedico> telefoneMedicos = new ArrayList<TelefoneMedico>();
			String sql = "SELECT * FROM tbl_telefone_medico WHERE id_medico = '" + idMedico + "' order by id;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				TelefoneMedico telefoneMedico = new TelefoneMedico();
				telefoneMedico.setId(rs.getLong("id"));
				telefoneMedico.setNumero(rs.getString("numero"));
				telefoneMedico.setTipo(rs.getString("tipo"));
				telefoneMedico.setMedico(rs.getLong("id_medico"));
				
				telefoneMedicos.add(telefoneMedico);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public TelefoneMedico consultarTM(String id) {
		try {
			
			String sql = "SELECT * FROM tbl_telefone_medico WHERE id = '" + id + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				TelefoneMedico telefoneMedico = new TelefoneMedico();
				telefoneMedico.setId(rs.getLong("id"));
				telefoneMedico.setNumero(rs.getString("numero"));
				telefoneMedico.setTipo(rs.getString("tipo"));
				telefoneMedico.setMedico(rs.getLong("id_medico"));
				
				return telefoneMedico;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateTM(TelefoneMedico tm) {
		try {
			
			String sql = "UPDATE tbl_telefone_medico SET id=?, numero=?, tipo=?, id_medico=? WHERE id = '" + tm.getId() + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, tm.getId());
			statement.setString(2, tm.getNumero());
			statement.setString(3, tm.getNumero());
			statement.setLong(4, tm.getMedico());
			
			statement.executeUpdate();
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
	
	public void deleteTM(String id) {
		try {
			
			String sql = "DELETE FROM tbl_telefone_medico WHERE id = '" + id + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.execute();
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

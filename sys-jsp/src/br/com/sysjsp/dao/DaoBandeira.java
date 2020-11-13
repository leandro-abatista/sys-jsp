package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.Bandeira;
import br.com.sysjsp.connect.SingleConnection;

public class DaoBandeira {
	
	private Connection connection;
	
	public DaoBandeira() {
		connection = SingleConnection.getConnection();
	}
	
	public void save(Bandeira bandeira) {
		try {
			
			String sql = "INSERT INTO tbl_bandeira(nome) VALUES (?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, bandeira.getNome());
			
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
	
	public List<Bandeira> listarTodasBandeiras(){
		try {
			
			List<Bandeira> bandeiras = new ArrayList<Bandeira>();
			
			String sql = "SELECT * FROM tbl_bandeira order by id;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				Bandeira ban = new Bandeira();
				ban.setId(rs.getLong("id"));
				ban.setNome(rs.getString("nome"));
				
				bandeiras.add(ban);
			}
			
			return bandeiras;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Bandeira consultarBandeira(String id){
		try {
			
			String sql = "SELECT * FROM tbl_bandeira WHERE id = '" + id + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				Bandeira ban = new Bandeira();
				ban.setId(rs.getLong("id"));
				ban.setNome(rs.getString("nome"));
				
				return ban;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(Bandeira bandeira) {
		try {
			
			String sql = "UPDATE tbl_bandeira SET id=?, nome=? WHERE id = '" + bandeira.getId() + "';";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, bandeira.getId());
			statement.setString(2, bandeira.getNome());
			
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
	
	public void delete(String id) {
		try {
			
			String sql = "DELETE FROM tbl_bandeira WHERE id = '" + id + "'";
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
	
	public boolean validarNome(String nome) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_bandeira WHERE nome = '" + nome + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			
			/*
			 * após buscar no banco e ter o resultado, verifica se existe o nome procurado
			 */
			if (resultado.next()) {
				return resultado.getInt("qtd") <= 0;/*return true*/
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

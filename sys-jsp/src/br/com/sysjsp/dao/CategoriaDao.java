package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.Categoria;
import br.com.sysjsp.connect.SingleConnection;

public class CategoriaDao {
	
private Connection connection;
	
	public CategoriaDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void saveCat(Categoria categoria) {
		try {
			
			String sql = "INSERT INTO tbl_categoria (descricao) VALUES (?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, categoria.getDescricao());
			
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
	
	public List<Categoria> listarTodosCat(){
		try {
			
			List<Categoria> categorias = new ArrayList<Categoria>();
			
			String sql = "SELECT * FROM tbl_categoria order by id;";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();
			
			while (rs.next()) {
				
				Categoria categoria = new Categoria();
				categoria.setId(rs.getLong("id"));
				categoria.setDescricao(rs.getString("descricao"));
				
				categorias.add(categoria);
			}
			
			return categorias;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Categoria consultarCat(String id) {
		try {
			
			String sql = "SELECT * FROM tbl_categoria WHERE id = '" + id + "'";
			PreparedStatement consultar = connection.prepareStatement(sql);
			ResultSet rs = consultar.executeQuery();
			
			if (rs.next()) {
				
				Categoria categoria = new Categoria();
				categoria.setId(rs.getLong("id"));
				categoria.setDescricao(rs.getString("descricao"));
				
				return categoria;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateEsp(Categoria categoria) {
		try {
			
			String sql = "UPDATE tbl_categoria SET id=?, descricao=? WHERE id = '" + categoria.getId() + "'";
			PreparedStatement update = connection.prepareStatement(sql);
			update.setLong(1, categoria.getId());
			update.setString(2, categoria.getDescricao());
			
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
			
			String sql = "DELETE FROM tbl_categoria WHERE  id = '" + id + "'";
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
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_categoria WHERE descricao = '" + descricao + "'";
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

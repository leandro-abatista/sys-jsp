package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.Telefone;
import br.com.sysjsp.connect.SingleConnection;

public class TelefoneDao {

	private Connection connection;

	public TelefoneDao() {
		connection = SingleConnection.getConnection();
	}

	public void saveT(Telefone telefone) {
		try {
			
			String sql = "INSERT INTO tbl_telefone(numero, tipo, id_cliente) VALUES (?, ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, telefone.getNumero());
			insert.setString(2, telefone.getTipo());
			insert.setLong(3, telefone.getCliente());
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

	public List<Telefone> listarTodos(Long idCliente) {
		try {
			
			List<Telefone> telefones = new ArrayList<Telefone>();
			
			String sql = "SELECT * FROM tbl_telefone WHERE id_cliente = '" + idCliente + "' order by id_cliente ";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();
			
			while (rs.next()) {
				
				Telefone telefone = new Telefone();
				telefone.setId(rs.getLong("id"));
				telefone.setNumero(rs.getString("numero"));
				telefone.setTipo(rs.getString("tipo"));
				telefone.setCliente(rs.getLong("id_cliente"));
				telefones.add(telefone);
			}
			
			return telefones;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Telefone consultarT(String id) {
		try {
			
			String sql = "SELECT * FROM tbl_telefone WHERE id = '" + id + "'";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();
			
			while (rs.next()) {
				
				Telefone telefone = new Telefone();
				telefone.setId(rs.getLong("id"));
				telefone.setNumero(rs.getString("numero"));
				telefone.setTipo(rs.getString("tipo"));
				telefone.setCliente(rs.getLong("id_cliente"));
				
				return telefone;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateT(Telefone telefone) {
		try {
			
			String sql = "UPDATE tbl_telefone SET id=?, numero=?, tipo=?, id_cliente=? WHERE id = '" + telefone.getId() + "'";
			PreparedStatement update = connection.prepareStatement(sql);
			update.setString(1, telefone.getNumero());
			update.setString(2, telefone.getTipo());
			update.setLong(3, telefone.getCliente());
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

	public void deleteT(String id) {
		try {
			
			String sql = "DELETE FROM tbl_telefone WHERE id = '" + id + "'";
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

	public boolean validarNumeroT(String numero) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_telefone WHERE numero = '" + numero + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
				return resultSet.getInt("qtd") <= 0;/*Return true*/
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

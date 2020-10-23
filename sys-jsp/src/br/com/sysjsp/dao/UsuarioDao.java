package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.AcessoJsp;
import br.com.sysjsp.connect.SingleConnection;

public class UsuarioDao {

	private Connection connection;

	public UsuarioDao() {
		connection = SingleConnection.getConnection();
	}

	public void salvarU(AcessoJsp acesso) {
		try {

			String sql = "INSERT INTO tbl_usuario (primeironome, sobrenome, ultimonome, usuario, senha, telefone, email)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, acesso.getPrimeironome());
			insert.setString(2, acesso.getSobrenome());
			insert.setString(3, acesso.getUltimonome());
			insert.setString(4, acesso.getUsuario());
			insert.setString(5, acesso.getSenha());
			insert.setString(6, acesso.getTelefone());
			insert.setString(7, acesso.getEmail());
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

	public List<AcessoJsp> listarTodos() {
		try {

			List<AcessoJsp> listar = new ArrayList<AcessoJsp>();

			String sql = "SELECT * FROM tbl_usuario order by id";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				AcessoJsp acesso = new AcessoJsp();
				acesso.setId(rs.getLong("id"));
				acesso.setPrimeironome(rs.getString("primeironome"));
				acesso.setSobrenome(rs.getString("sobrenome"));
				acesso.setUltimonome(rs.getString("ultimonome"));
				acesso.setUsuario(rs.getString("usuario"));
				acesso.setSenha(rs.getString("senha"));
				acesso.setTelefone(rs.getString("telefone"));
				acesso.setEmail(rs.getString("email"));

				listar.add(acesso);

			}

			return listar;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public AcessoJsp consultarU(String id) {
		try {

			String sql = "SELECT * FROM tbl_usuario WHERE id = '" + id + "'";

			PreparedStatement consulta = connection.prepareStatement(sql);
			ResultSet rs = consulta.executeQuery();

			if (rs.next()) {

				AcessoJsp acesso = new AcessoJsp();
				acesso.setId(rs.getLong("id"));
				acesso.setPrimeironome(rs.getString("primeironome"));
				acesso.setSobrenome(rs.getString("sobrenome"));
				acesso.setUltimonome(rs.getString("ultimonome"));
				acesso.setUsuario(rs.getString("usuario"));
				acesso.setSenha(rs.getString("senha"));
				acesso.setTelefone(rs.getString("telefone"));
				acesso.setEmail(rs.getString("email"));
				return acesso;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateU(AcessoJsp acessoJsp) {
		try {

			String sql = "UPDATE tbl_usuario "
					+ "SET primeironome=?, sobrenome=?, ultimonome=?, usuario=?, senha=?, telefone=?, email=?"
					+ "WHERE id = '" + acessoJsp.getId() + "'";
			PreparedStatement update = connection.prepareStatement(sql);
			update.setString(1, acessoJsp.getPrimeironome());
			update.setString(2, acessoJsp.getSobrenome());
			update.setString(3, acessoJsp.getUltimonome());
			update.setString(4, acessoJsp.getUsuario());
			update.setString(5, acessoJsp.getSenha());
			update.setString(6, acessoJsp.getTelefone());
			update.setString(7, acessoJsp.getEmail());
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

	public void deleteU(String id) {
		try {

			String sql = "DELETE FROM tbl_usuario" + " WHERE id = '" + id + "'";
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

	public boolean validarUsuario(String usuario) {
		try {

			String sql = "SELECT COUNT(1) AS qtd FROM tbl_usuario WHERE usuario = '" + usuario + "'";
			PreparedStatement validar = connection.prepareStatement(sql);
			ResultSet rs = validar.executeQuery();

			if (rs.next()) {
				/* return true */
				return rs.getInt("qtd") <= 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

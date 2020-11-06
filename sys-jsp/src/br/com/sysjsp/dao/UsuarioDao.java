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

			String sql = "INSERT INTO tbl_usuario (primeironome, sobrenome, ultimonome, usuario, senha, telefone, email, ativo, perfil)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, acesso.getPrimeironome());
			insert.setString(2, acesso.getSobrenome());
			insert.setString(3, acesso.getUltimonome());
			insert.setString(4, acesso.getUsuario());
			insert.setString(5, acesso.getSenha());
			insert.setString(6, acesso.getTelefone());
			insert.setString(7, acesso.getEmail());
			insert.setBoolean(8, acesso.isAtivo());
			insert.setString(9, acesso.getPerfil());
			
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
			/*esse simbolo '<>' -> quer dizer diferente*/
			/*esse trecho do código -> WHERE usuario <> 'admin' ele esconde o usuário admin na tela*/
			String sql = "SELECT * FROM tbl_usuario WHERE usuario <> 'admin' order by id";
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
				acesso.setAtivo(rs.getBoolean("ativo"));
				acesso.setPerfil(rs.getString("perfil"));

				listar.add(acesso);

			}

			return listar;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<AcessoJsp> pesquisarUsuarios(String descricaoConsulta) {
		try {

			List<AcessoJsp> listar = new ArrayList<AcessoJsp>();

			String sql = "SELECT * FROM tbl_usuario WHERE usuario <> 'admin' AND primeironome like '%" + descricaoConsulta + "%'";
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
				acesso.setAtivo(rs.getBoolean("ativo"));
				acesso.setPerfil(rs.getString("perfil"));

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

			String sql = "SELECT * FROM tbl_usuario WHERE id = '" + id + "' AND usuario <> 'admin'";
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
				acesso.setAtivo(rs.getBoolean("ativo"));
				acesso.setPerfil(rs.getString("perfil"));
				
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
					+ "SET id=?, primeironome=?, sobrenome=?, ultimonome=?, usuario=?, senha=?, telefone=?, email=?, ativo=?, perfil=? "
					+ "WHERE id = '" + acessoJsp.getId() + "'";
			PreparedStatement update = connection.prepareStatement(sql);
			update.setLong(1, acessoJsp.getId());
			update.setString(2, acessoJsp.getPrimeironome());
			update.setString(3, acessoJsp.getSobrenome());
			update.setString(4, acessoJsp.getUltimonome());
			update.setString(5, acessoJsp.getUsuario());
			update.setString(6, acessoJsp.getSenha());
			update.setString(7, acessoJsp.getTelefone());
			update.setString(8, acessoJsp.getEmail());
			update.setBoolean(9, acessoJsp.isAtivo());
			update.setString(10, acessoJsp.getPerfil());
			
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

			String sql = "DELETE FROM tbl_usuario" + " WHERE id = '" + id + "' AND usuario <> 'admin'";
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

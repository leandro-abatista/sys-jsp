package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.Produto;
import br.com.sysjsp.connect.SingleConnection;

public class ProdutoDao {

	private Connection connection;

	public ProdutoDao() {
		connection = SingleConnection.getConnection();
	}

	public void saveP(Produto produto) {
		try {

			String sql = "INSERT INTO public.tbl_produto(descricao, quantidade, valorcompra, valoritem, categoria)"
					+ "    VALUES (?, ?, ?, ?, ?);";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, produto.getDescricao());
			insert.setInt(2, produto.getQuantidade());
			insert.setDouble(3, produto.getValorCompra());
			insert.setDouble(4, produto.getValorItem());
			insert.setString(5, produto.getCategoria());
			insert.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public List<Produto> listarTodosP() {
		try {

			List<Produto> produtos = new ArrayList<Produto>();

			String sql = "SELECT * FROM tbl_produto order by id;";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();

			while (rs.next()) {

				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValorCompra(rs.getDouble("valorCompra"));
				produto.setValorItem(rs.getDouble("valorItem"));
				produto.setCategoria(rs.getString("categoria"));

				produtos.add(produto);
			}

			return produtos;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Produto consultarP(String id) {
		try {

			String sql = "SELECT * FROM tbl_produto WHERE id = '" + id + "'";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet rs = select.executeQuery();

			while (rs.next()) {

				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValorCompra(rs.getDouble("valorCompra"));
				produto.setValorItem(rs.getDouble("valorItem"));
				produto.setCategoria(rs.getString("categoria"));

				return produto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateP(Produto produto) {
		try {

			String sql = "UPDATE tbl_produto"
					+ " SET id=?, descricao=?, quantidade=?, valorcompra=?, valoritem=?, categoria=?"
					+ " WHERE id = '" + produto.getId() + "'";
			PreparedStatement update = connection.prepareStatement(sql);
			update.setLong(1, produto.getId());
			update.setString(2, produto.getDescricao());
			update.setInt(3, produto.getQuantidade());
			update.setDouble(4, produto.getValorCompra());
			update.setDouble(5, produto.getValorItem());
			update.setString(6, produto.getCategoria());
			update.executeUpdate();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();

			try {

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void deleteP(String id) {
		try {
			
			String sql = "DELETE FROM tbl_produto WHERE id = '" + id + "'";
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();
			connection.commit();
			
		} catch (Exception e) {
			e.printStackTrace();

			try {

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public boolean validarDescricaoP(String descricao) {
		try {
			
			String sql = "SELECT COUNT(1) AS qtd FROM tbl_produto WHERE descricao = '" + descricao + "'";
			PreparedStatement validar = connection.prepareStatement(sql);
			ResultSet rs = validar.executeQuery();
			
			if (rs.next()) {
				/*Se retornar menor ou igual a 0 é true, caso contrário é false*/
				return rs.getInt("qtd") <= 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

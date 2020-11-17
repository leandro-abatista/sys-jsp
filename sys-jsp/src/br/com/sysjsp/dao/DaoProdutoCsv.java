package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.sysjsp.classes.model.Bandeira;
import br.com.sysjsp.classes.model.ProdutoCsv;
import br.com.sysjsp.connect.SingleConnection;

public class DaoProdutoCsv {
	
	private Connection connection;
	
	public DaoProdutoCsv() {
		connection = SingleConnection.getConnection();
	}
	
	public void save(ProdutoCsv procsv) {
		try {
			
			String sql = "INSERT INTO tbl_produtocsv(" + 
					"            revenda, cnpjrevenda, descricaoproduto, datacoleta, valorcompra, " + 
					"            valorvenda, quantidade, unidademedida, tipo, estado, cidade, id_bandeira) " + 
					"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, procsv.getRevenda());
			statement.setString(2, procsv.getCnpjRevenda());
			statement.setString(3, procsv.getDescricaoProduto());
			statement.setString(4, procsv.getDataColeta());
			statement.setDouble(5, procsv.getValorCompra());
			statement.setDouble(6, procsv.getValorVenda());
			statement.setInt(7, procsv.getQuantidade());
			statement.setString(8, procsv.getUnidadeMedida());
			statement.setString(9, procsv.getTipo());
			statement.setString(10, procsv.getEstado());
			statement.setString(11, procsv.getCidade());
			statement.setLong(12, procsv.getId_bandeira());
			
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
	
	public List<ProdutoCsv> listarTodosProdutosCsv(){
		try {
			
			List<ProdutoCsv> produtoCsvs = new ArrayList<ProdutoCsv>();
			
			String sql = "SELECT * FROM tbl_produtocsv order by id;";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				ProdutoCsv procsv = new ProdutoCsv();
				procsv.setId(rs.getLong("id"));
				procsv.setRevenda(rs.getString("revenda"));
				procsv.setCnpjRevenda(rs.getString("cnpjRevenda"));
				procsv.setDescricaoProduto(rs.getString("descricaoProduto"));
				procsv.setDataColeta(rs.getString("dataColeta"));
				procsv.setValorCompra(rs.getDouble("valorCompra"));
				procsv.setValorVenda(rs.getDouble("valorVenda"));
				procsv.setQuantidade(rs.getInt("quantidade"));
				procsv.setUnidadeMedida(rs.getString("unidadeMedida"));
				procsv.setTipo(rs.getString("tipo"));
				procsv.setEstado(rs.getString("estado"));
				procsv.setCidade(rs.getString("cidade"));
				procsv.setId_bandeira(rs.getLong("id_bandeira"));
				
				produtoCsvs.add(procsv);
			}
			
			return produtoCsvs;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
	
	public ProdutoCsv consultarProdutoCsv(String id){
		try {
			
			String sql = "SELECT * FROM tbl_produtocsv WHERE id = '" + id + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				ProdutoCsv procsv = new ProdutoCsv();
				procsv.setId(rs.getLong("id"));
				procsv.setRevenda(rs.getString("revenda"));
				procsv.setCnpjRevenda(rs.getString("cnpjRevenda"));
				procsv.setDescricaoProduto(rs.getString("descricaoProduto"));
				procsv.setDataColeta(rs.getString("dataColeta"));
				procsv.setValorCompra(rs.getDouble("valorCompra"));
				procsv.setValorVenda(rs.getDouble("valorVenda"));
				procsv.setQuantidade(rs.getInt("quantidade"));
				procsv.setUnidadeMedida(rs.getString("unidadeMedida"));
				procsv.setTipo(rs.getString("tipo"));
				procsv.setEstado(rs.getString("estado"));
				procsv.setCidade(rs.getString("cidade"));
				procsv.setId_bandeira(rs.getLong("id_bandeira"));
				
				return procsv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(ProdutoCsv procsv) {
		try {
			
			String sql = "UPDATE tbl_produtocsv " + 
					"     SET id=?, revenda=?, cnpjrevenda=?, descricaoproduto=?, datacoleta=?, " + 
					"         valorcompra=?, valorvenda=?, quantidade=?, unidademedida=?, tipo=?, " + 
					"         estado=?, cidade=?, id_bandeira=? " + 
					"    WHERE id = '" + procsv.getId() + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, procsv.getId());
			statement.setString(2, procsv.getRevenda());
			statement.setString(3, procsv.getCnpjRevenda());
			statement.setString(4, procsv.getDescricaoProduto());
			statement.setString(5, procsv.getDataColeta());
			statement.setDouble(6, procsv.getValorCompra());
			statement.setDouble(7, procsv.getValorVenda());
			statement.setInt(8, procsv.getQuantidade());
			statement.setString(9, procsv.getUnidadeMedida());
			statement.setString(10, procsv.getTipo());
			statement.setString(11, procsv.getEstado());
			statement.setString(12, procsv.getCidade());
			statement.setLong(13, procsv.getId_bandeira());
			
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
			
			String sql = "DELETE FROM tbl_produtocsv WHERE id = '" + id + "';";
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
	
	public boolean validarCnpj(String revendaCnpj) {
		try {
			
			String sql = "select count(1) as qtd from tbl_produtocsv where id = '" + revendaCnpj + "'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultado = statement.executeQuery();
			
			/*
			 * após buscar no banco e ter o resultado, verifica se existe o login procurado
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

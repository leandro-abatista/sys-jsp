package br.com.sysjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import br.com.sysjsp.connect.SingleConnection;

public class LoginDao {
	
	private Connection connection;
	
	public LoginDao() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String usuario, String senha) {
		try {
			
			String sql = "select * from tbl_usuario where usuario = '" + usuario + "' and senha = '" + senha + "'";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				/*retorna true se possuir usuário no banco*/
				return true;
			} else {
				/*retorna false se não possuir usuário no banco*/
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

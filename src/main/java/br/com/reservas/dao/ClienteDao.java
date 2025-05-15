package br.com.reservas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.reservas.model.Cliente;
import br.com.reservas.util.ConexaoUtil;

public class ClienteDao {
	
	 public void inserir(Cliente cliente) {
	        String sql = "INSERT INTO cliente (nome, email, telefone) VALUES (?, ?, ?)"; //evita sql injection

	        try (Connection conn = ConexaoUtil.getConnection();
	        	PreparedStatement stmt = conn.prepareStatement(sql)) {
		        stmt.setString(1, cliente.getNome());
		        stmt.setString(2, cliente.getEmail());
		        stmt.setString(3, cliente.getTelefone());

		        stmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

}

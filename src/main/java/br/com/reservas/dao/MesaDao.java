package br.com.reservas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.reservas.model.Mesa;
import br.com.reservas.util.ConexaoUtil;


public class MesaDao {
	public void inserir(Mesa mesa) {
		String sql  = "INSERT INTO mesa (numero, capacidade) VALUES (?, ?)";
		
		try (Connection conn = ConexaoUtil.getConnection();
	        	PreparedStatement stmt = conn.prepareStatement(sql)) {
		        stmt.setInt(1, mesa.getNumero());
		        stmt.setInt(2, mesa.getCapacidade());

		        stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}

package br.com.reservas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
	
	public List<Mesa> listarTodos() {
	    String sql = "SELECT * FROM mesa";
	    List<Mesa> mesas = new ArrayList<>();

	    try (Connection conn = ConexaoUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Mesa mesa = new Mesa();
	            mesa.setId(rs.getInt("id"));
	            mesa.setNumero(rs.getInt("numero"));
	            mesa.setCapacidade(rs.getInt("capacidade"));
	            mesas.add(mesa);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return mesas;
	}


}

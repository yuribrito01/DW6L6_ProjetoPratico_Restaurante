package br.com.reservas.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.reservas.model.Reserva;
import br.com.reservas.util.ConexaoUtil;

public class ReservaDao {
	public void inserir(Reserva reserva) {
        String sql = "INSERT INTO reserva (cliente_id, mesa_id, data_hora) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, reserva.getCliente());
            stmt.setInt(2, reserva.getMesa());
            stmt.setObject(3, reserva.getDataHora());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public List<Reserva> listarTodas() {
        String sql = "SELECT * FROM reserva";
        List<Reserva> reservas = new ArrayList<>();

        try (Connection conn = ConexaoUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Reserva r = new Reserva();
                r.setId(rs.getInt("id"));
                r.setCliente(rs.getInt("cliente_id"));
                r.setMesa(rs.getInt("mesa_id"));
                r.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());

                reservas.add(r);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservas;
    }

}

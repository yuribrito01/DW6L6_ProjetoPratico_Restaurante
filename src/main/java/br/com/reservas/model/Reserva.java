package br.com.reservas.model;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private int clienteId;
    private int mesaId;
    private LocalDateTime dataHora;
    
    public Reserva() {}

    public Reserva(int id, int clienteId, int mesaId, LocalDateTime dataHora) {
        this.id = id;
        this.clienteId = clienteId;
        this.mesaId = mesaId;
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getMesaId() {
        return mesaId;
    }

    public void setMesaId(int mesaId) {
        this.mesaId = mesaId;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

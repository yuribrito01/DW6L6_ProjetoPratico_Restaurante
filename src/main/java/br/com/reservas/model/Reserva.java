package br.com.reservas.model;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private int cliente;
    private int mesa;
    private LocalDateTime dataHora;
    
    public Reserva() {}

    public Reserva(int cliente, int mesa, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.mesa = mesa;
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}

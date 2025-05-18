package br.com.reservas.model;

public class Mesa {
    private int id;
    private int numero;
    private int capacidade;
    
    public Mesa() {}

    public Mesa(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}

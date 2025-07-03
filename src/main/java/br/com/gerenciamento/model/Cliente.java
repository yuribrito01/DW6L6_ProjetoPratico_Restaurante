package br.com.gerenciamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @Size(min = 3, max = 50, message = "O Nome deve conter entre 3 a 50 caracteres")
    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

    @Column(name = "email")
    @Email(message = "Digite um email válido")
    private String email;

    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "funcao")
    private String funcao;

    // GETTERS E SETTERS (Essenciais para o Thymeleaf)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
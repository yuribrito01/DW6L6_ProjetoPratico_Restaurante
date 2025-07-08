package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; // Importe esta classe

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Adicionamos a anotação @Query para definir a busca explicitamente
    @Query("SELECT c FROM Cliente c WHERE upper(c.nome) LIKE upper(concat('%', :nome, '%'))")
    List<Cliente> findByNomeContainingIgnoreCase(@Param("nome") String nome);

}
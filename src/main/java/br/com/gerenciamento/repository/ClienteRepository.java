package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
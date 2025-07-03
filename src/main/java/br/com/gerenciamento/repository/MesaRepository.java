package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
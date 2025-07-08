package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
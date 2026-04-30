package br.com.ebac.carros.repository;

import br.com.ebac.carros.entity.Acessorio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {
    Optional<Acessorio> findByNome(String nome);
}
package br.com.ebac.carros.repository;

import br.com.ebac.carros.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByMarcaId(Long marcaId);

    @Query("SELECT c FROM Carro c JOIN FETCH c.marca LEFT JOIN FETCH c.acessorios")
    List<Carro> findAllWithDetails();
}
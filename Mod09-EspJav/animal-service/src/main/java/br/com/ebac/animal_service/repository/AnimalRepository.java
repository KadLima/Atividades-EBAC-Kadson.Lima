package br.com.ebac.animal_service.repository;

import br.com.ebac.animal_service.dto.AnimalRecebedorDTO;
import br.com.ebac.animal_service.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository <Animal, Integer> {
    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    @Query("SELECT NEW br.com.ebac.animal_service.dto.AnimalRecebedorDTO(a.nomeRecebedor, COUNT(a)) " +
            "FROM Animal a WHERE FUNCTION('YEAR', a.dataEntrada) = :ano " +
            "GROUP BY a.nomeRecebedor ORDER BY a.nomeRecebedor")
    List<AnimalRecebedorDTO> countAnimaisPorRecebedorNoAno(@Param("ano") int ano);

    @Query("SELECT NEW br.com.ebac.animal_service.dto.AnimalRecebedorDTO(a.nomeRecebedor, COUNT(a)) " +
            "FROM Animal a WHERE FUNCTION('YEAR', a.dataEntrada) = :ano " +
            "AND a.dataAdocao IS NOT NULL " +
            "GROUP BY a.nomeRecebedor ORDER BY a.nomeRecebedor")
    List<AnimalRecebedorDTO> countAnimaisAdotadosPorRecebedorNoAno(@Param("ano") int ano);
}

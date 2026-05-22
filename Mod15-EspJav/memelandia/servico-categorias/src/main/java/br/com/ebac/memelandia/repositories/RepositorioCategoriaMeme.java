package br.com.ebac.memelandia.repositories;

import br.com.ebac.memelandia.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepositorioCategoriaMeme extends JpaRepository<CategoriaMeme, Long> {
    List<CategoriaMeme> findByUsuarioId(Long usuarioId);
}

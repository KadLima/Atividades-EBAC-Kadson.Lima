package br.com.ebac.memelandia.repositories;

import br.com.ebac.memelandia.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepositorioMeme extends JpaRepository<Meme, Long> {
    List<Meme> findByUsuarioId(Long usuarioId);
    List<Meme> findByCategoriaId(Long categoriaId);
}

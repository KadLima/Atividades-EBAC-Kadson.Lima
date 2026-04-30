package br.com.ebac.produto_service.repository;

import br.com.ebac.produto_service.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);
    List<Produto> findByCategoriaIgnoreCase(String categoria);
    List<Produto> findByAtivoTrue();
    List<Produto> findByAtivoFalse();
    List<Produto> findByQuantidadeEstoqueLessThan(Integer limite);
    List<Produto> findByPrecoBetween(BigDecimal precoMin, BigDecimal precoMax);
    List<Produto> findByPrecoGreaterThan(BigDecimal preco);
    List<Produto> findByPrecoLessThan(BigDecimal preco);
    List<Produto> findByCategoriaIgnoreCaseAndAtivoTrue(String categoria);

    @Query("SELECT p FROM Produto p WHERE p.preco > :preco AND p.categoria = :categoria")
    List<Produto> findProdutosCarosPorCategoria(@Param("preco") BigDecimal preco, @Param("categoria") String categoria);

    @Query(value = "SELECT * FROM produto WHERE preco < :valor AND ativo = true ORDER BY preco", nativeQuery = true)
    List<Produto> findProdutosEmPromocao(@Param("valor") BigDecimal valor);
}
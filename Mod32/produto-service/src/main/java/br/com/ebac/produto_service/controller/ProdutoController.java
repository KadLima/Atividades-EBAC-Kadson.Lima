package br.com.ebac.produto_service.controller;

import br.com.ebac.produto_service.entity.Produto;
import br.com.ebac.produto_service.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    // Listar todos os produtos
    @GetMapping
    public List<Produto> findAll() {
        return repository.findAll();
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Criar novo produto
    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    // Atualizar produto
    @PutMapping("/{id}")
    public Produto update(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Produto produto = repository.findById(id).orElse(null);
        if (produto != null) {
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
            produto.setAtivo(produtoAtualizado.getAtivo());
            produto.setCategoria(produtoAtualizado.getCategoria());
            return repository.save(produto);
        }
        return null;
    }

    // Deletar produto
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // Buscar produtos ativos
    @GetMapping("/ativos")
    public List<Produto> findAtivos() {
        return repository.findByAtivoTrue();
    }

    // Buscar produtos inativos
    @GetMapping("/inativos")
    public List<Produto> findInativos() {
        return repository.findByAtivoFalse();
    }

    // Buscar por nome
    @GetMapping("/buscar/nome")
    public List<Produto> findByNome(@RequestParam String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    // Buscar por categoria
    @GetMapping("/buscar/categoria")
    public List<Produto> findByCategoria(@RequestParam String categoria) {
        return repository.findByCategoriaIgnoreCase(categoria);
    }

    // Buscar produtos com estoque baixo
    @GetMapping("/estoque-baixo")
    public List<Produto> findByEstoqueBaixo(@RequestParam Integer limite) {
        return repository.findByQuantidadeEstoqueLessThan(limite);
    }

    // Buscar por faixa de preço
    @GetMapping("/faixa-preco")
    public List<Produto> findByFaixaPreco(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return repository.findByPrecoBetween(min, max);
    }

    // Buscar produtos em promoção (preço menor que valor informado)
    @GetMapping("/promocao")
    public List<Produto> findEmPromocao(@RequestParam BigDecimal valorMaximo) {
        return repository.findProdutosEmPromocao(valorMaximo);
    }

    // Buscar produtos caros por categoria
    @GetMapping("/caros-por-categoria")
    public List<Produto> findProdutosCarosPorCategoria(
            @RequestParam BigDecimal precoMinimo,
            @RequestParam String categoria) {
        return repository.findProdutosCarosPorCategoria(precoMinimo, categoria);
    }
}
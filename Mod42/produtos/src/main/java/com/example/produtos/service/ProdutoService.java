package com.example.produtos.service;

import com.example.produtos.entity.Produto;
import com.example.produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto cadastrar(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Produto atualizar(Long id, Produto atualizado) {
        Optional<Produto> existente = repository.findById(id);

        if (existente.isPresent()) {
            Produto produto = existente.get();
            produto.setNome(atualizado.getNome());
            produto.setPreco(atualizado.getPreco());
            return repository.save(produto);
        }

        return null;
    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

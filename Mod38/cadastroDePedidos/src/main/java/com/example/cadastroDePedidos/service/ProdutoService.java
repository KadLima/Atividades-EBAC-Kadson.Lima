package com.example.cadastroDePedidos.service;

import com.example.cadastroDePedidos.entity.Produto;
import com.example.cadastroDePedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvar(Produto produto) {

        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório");
        }

        if (produto.getPreco() == null || produto.getPreco() <= 0) {
            throw new RuntimeException("Preço inválido");
        }

        return repository.save(produto);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

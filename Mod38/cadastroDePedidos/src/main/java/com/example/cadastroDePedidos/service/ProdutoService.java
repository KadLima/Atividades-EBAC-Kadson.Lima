package com.example.cadastroDePedidos.service;

import com.example.cadastroDePedidos.entity.Pedido;
import com.example.cadastroDePedidos.entity.Produto;
import com.example.cadastroDePedidos.repository.PedidoRepository;
import com.example.cadastroDePedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final PedidoRepository pedidoRepository;

    public ProdutoService(ProdutoRepository repository,
                          PedidoRepository pedidoRepository) {
        this.repository = repository;
        this.pedidoRepository = pedidoRepository;
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public void deletar(Long id) {

        // 🔥 Remove vínculo com pedidos (mantém histórico)
        List<Pedido> pedidos = pedidoRepository.findByProdutoId(id);

        for (Pedido p : pedidos) {
            p.setProduto(null);
        }

        pedidoRepository.saveAll(pedidos);

        repository.deleteById(id);
    }
}
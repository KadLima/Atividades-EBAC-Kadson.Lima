package com.example.cadastroDePedidos.service;

import com.example.cadastroDePedidos.entity.Pedido;
import com.example.cadastroDePedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido salvar(Pedido pedido) {

        if (pedido.getCliente() == null) {
            throw new RuntimeException("Cliente é obrigatório");
        }

        if (pedido.getProduto() == null) {
            throw new RuntimeException("Produto é obrigatório");
        }

        if (pedido.getData() == null) {
            throw new RuntimeException("Data é obrigatória");
        }

        return repository.save(pedido);
    }

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
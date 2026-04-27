package com.example.cadastroDePedidos.service;

import com.example.cadastroDePedidos.entity.Cliente;
import com.example.cadastroDePedidos.entity.Pedido;
import com.example.cadastroDePedidos.repository.ClienteRepository;
import com.example.cadastroDePedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    private final PedidoRepository pedidoRepository;

    public ClienteService(ClienteRepository repository,
                          PedidoRepository pedidoRepository) {
        this.repository = repository;
        this.pedidoRepository = pedidoRepository;
    }

    public Cliente salvar(Cliente cliente) {

        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório");
        }

        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new RuntimeException("CPF é obrigatório");
        }

        return repository.save(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public void deletar(Long id) {

        System.out.println(">>> SERVICE: deletando cliente ID: " + id);

        List<Pedido> pedidos = pedidoRepository.findByClienteId(id);

        System.out.println(">>> Pedidos encontrados: " + pedidos.size());

        for (Pedido p : pedidos) {
            p.setCliente(null);
        }

        pedidoRepository.saveAll(pedidos);

        repository.deleteById(id);

        System.out.println(">>> Cliente removido do banco");
    }
}
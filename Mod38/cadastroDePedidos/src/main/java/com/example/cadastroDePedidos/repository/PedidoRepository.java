package com.example.cadastroDePedidos.repository;

import com.example.cadastroDePedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long id);
    List<Pedido> findByProdutoId(Long id);
}
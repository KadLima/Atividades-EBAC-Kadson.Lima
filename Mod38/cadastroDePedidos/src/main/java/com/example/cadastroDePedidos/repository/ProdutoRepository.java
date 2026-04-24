package com.example.cadastroDePedidos.repository;

import com.example.cadastroDePedidos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

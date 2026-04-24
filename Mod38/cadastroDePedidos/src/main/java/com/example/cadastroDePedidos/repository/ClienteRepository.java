package com.example.cadastroDePedidos.repository;

import com.example.cadastroDePedidos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

package com.example.cadastroDePedidos.config;

import com.example.cadastroDePedidos.entity.*;
import com.example.cadastroDePedidos.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(ClienteRepository clienteRepo,
                           ProdutoRepository produtoRepo,
                           PedidoRepository pedidoRepo) {
        return args -> {

            Cliente cliente = new Cliente();
            cliente.setNome("Kadson");
            cliente.setCpf("12345678900");
            cliente.setTelefone("81999999999");
            cliente.setEndereco("Recife");
            clienteRepo.save(cliente);

            Produto produto = new Produto();
            produto.setNome("Notebook");
            produto.setPreco(3500.0);
            produtoRepo.save(produto);

            Pedido pedido = new Pedido();
            pedido.setData(new java.util.Date());
            pedido.setCliente(cliente);
            pedido.setProduto(produto);
            pedidoRepo.save(pedido);

            System.out.println("Dados inseridos no banco!");
        };
    }
}

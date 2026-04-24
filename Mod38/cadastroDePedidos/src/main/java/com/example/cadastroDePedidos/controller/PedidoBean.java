package com.example.cadastroDePedidos.controller;

import com.example.cadastroDePedidos.entity.Cliente;
import com.example.cadastroDePedidos.entity.Pedido;
import com.example.cadastroDePedidos.entity.Produto;
import com.example.cadastroDePedidos.service.ClienteService;
import com.example.cadastroDePedidos.service.PedidoService;
import com.example.cadastroDePedidos.service.ProdutoService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;
import java.util.List;

@Controller
@RequestScope
public class PedidoBean {

    private final PedidoService service;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    private Pedido pedido = new Pedido();

    private List<Cliente> clientes;
    private List<Produto> produtos;
    private List<Pedido> pedidos;

    public PedidoBean(PedidoService service,
                      ClienteService clienteService,
                      ProdutoService produtoService) {
        this.service = service;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }

    @PostConstruct
    public void init() {
        clientes = clienteService.listar();
        produtos = produtoService.listar();
        pedidos = service.listarTodos();
    }

    public String salvar() {

        try {
            pedido.setNomeCliente(pedido.getCliente().getNome());
            pedido.setNomeProduto(pedido.getProduto().getNome());
            pedido.setPrecoProduto(pedido.getProduto().getPreco());

            service.salvar(pedido);

            pedido = new Pedido();

            return "sucesso.xhtml";

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
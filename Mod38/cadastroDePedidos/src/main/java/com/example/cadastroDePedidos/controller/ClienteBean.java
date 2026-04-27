package com.example.cadastroDePedidos.controller;

import com.example.cadastroDePedidos.entity.Cliente;
import com.example.cadastroDePedidos.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Controller
@SessionScope
public class ClienteBean {

    private final ClienteService service;

    private Cliente cliente = new Cliente();
    private List<Cliente> clientes;

    public ClienteBean(ClienteService service) {
        this.service = service;
    }

    public String salvar() {
        service.salvar(cliente);
        cliente = new Cliente();
        return "cliente.xhtml?faces-redirect=true";
    }

    public List<Cliente> getClientes() {
        return service.listar();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void editar(Cliente c) {
        this.cliente = c;
    }

    public String excluir(Cliente c) {
        System.out.println(">>> EXCLUINDO CLIENTE ID: " + c.getId());
        service.deletar(c.getId());
        return null;
    }
}
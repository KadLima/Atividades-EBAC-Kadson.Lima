package com.example.cadastroDePedidos.controller;

import com.example.cadastroDePedidos.entity.Produto;
import com.example.cadastroDePedidos.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Controller
@SessionScope
public class ProdutoBean {

    private final ProdutoService service;

    private Produto produto = new Produto();

    public ProdutoBean(ProdutoService service) {
        this.service = service;
    }

    public String salvar() {
        service.salvar(produto);
        produto = new Produto();
        return "produto.xhtml?faces-redirect=true";
    }

    public List<Produto> getProdutos() {
        return service.listar();
    }

    public Produto getProduto() {
        return produto;
    }

    public void editar(Produto p) {
        this.produto = p;
    }

    public String excluir(Produto p) {
        System.out.println(">>> EXCLUINDO PRODUTO ID: " + p.getId());
        service.deletar(p.getId());
        return null;
    }
}
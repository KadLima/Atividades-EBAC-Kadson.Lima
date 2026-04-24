package com.example.cadastroDePedidos.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Produto produto;

    private String nomeCliente;
    private String nomeProduto;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    private Double precoProduto;

    public Pedido() {}

    public Long getId() { return id; }
    public Date getData() { return data; }
    public Cliente getCliente() { return cliente; }
    public Produto getProduto() { return produto; }

    public void setId(Long id) { this.id = id; }
    public void setData(Date data) { this.data = data; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public void setProduto(Produto produto) { this.produto = produto; }
}

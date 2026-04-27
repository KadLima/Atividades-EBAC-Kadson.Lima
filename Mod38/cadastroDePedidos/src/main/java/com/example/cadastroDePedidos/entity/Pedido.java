package com.example.cadastroDePedidos.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = true)
    private Produto produto;

    // 🔥 CAMPOS DE HISTÓRICO
    private String nomeCliente;
    private String nomeProduto;
    private Double precoProduto;

    // GETTERS E SETTERS

    public Long getId() { return id; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public String getNomeProduto() { return nomeProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }

    public Double getPrecoProduto() { return precoProduto; }
    public void setPrecoProduto(Double precoProduto) { this.precoProduto = precoProduto; }
}
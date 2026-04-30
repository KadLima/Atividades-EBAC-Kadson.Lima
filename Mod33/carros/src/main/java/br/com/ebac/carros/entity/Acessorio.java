package br.com.ebac.carros.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acessorio")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column
    private String descricao;

    @Column
    private Double preco;

    @ManyToMany(mappedBy = "acessorios", fetch = FetchType.LAZY)
    private List<Carro> carros = new ArrayList<>();

    public Acessorio() {}

    public Acessorio(String nome, String descricao, Double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public List<Carro> getCarros() { return carros; }
    public void setCarros(List<Carro> carros) { this.carros = carros; }
}
package br.com.ebac.carros.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column
    private String paisOrigem;

    @Column
    private Integer anoFundacao;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Carro> carros = new ArrayList<>();

    public Marca() {}

    public Marca(String nome, String paisOrigem, Integer anoFundacao) {
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.anoFundacao = anoFundacao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPaisOrigem() { return paisOrigem; }
    public void setPaisOrigem(String paisOrigem) { this.paisOrigem = paisOrigem; }

    public Integer getAnoFundacao() { return anoFundacao; }
    public void setAnoFundacao(Integer anoFundacao) { this.anoFundacao = anoFundacao; }

    public List<Carro> getCarros() { return carros; }
    public void setCarros(List<Carro> carros) { this.carros = carros; }

    public void adicionarCarro(Carro carro) {
        carros.add(carro);
        carro.setMarca(this);
    }
}
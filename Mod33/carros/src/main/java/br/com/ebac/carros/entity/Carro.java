package br.com.ebac.carros.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private Year ano;

    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

    @Column
    private String cor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "carro_acessorio",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<Acessorio> acessorios = new ArrayList<>();

    public Carro() {}

    public Carro(String modelo, String placa, Year ano, BigDecimal preco, String cor) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.preco = preco;
        this.cor = cor;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public Year getAno() { return ano; }
    public void setAno(Year ano) { this.ano = ano; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    public List<Acessorio> getAcessorios() { return acessorios; }
    public void setAcessorios(List<Acessorio> acessorios) { this.acessorios = acessorios; }

    public void adicionarAcessorio(Acessorio acessorio) {
        acessorios.add(acessorio);
        acessorio.getCarros().add(this);
    }
}
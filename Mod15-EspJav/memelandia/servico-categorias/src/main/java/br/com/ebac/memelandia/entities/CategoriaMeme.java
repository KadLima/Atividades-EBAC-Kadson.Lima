package br.com.ebac.memelandia.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "categoria_meme")
public class CategoriaMeme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_categoria_meme")
    @SequenceGenerator(name = "sequence_categoria_meme", sequenceName = "sequence_categoria_meme", allocationSize = 50)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    /** ID do usuário que criou a categoria (referência lógica, sem FK de banco). */
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    public CategoriaMeme() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Date getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(Date dataCadastro) { this.dataCadastro = dataCadastro; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}

package br.com.ebac.memelandia.entities;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "meme")
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_meme")
    @SequenceGenerator(name = "sequence_meme", sequenceName = "sequence_meme", allocationSize = 50)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    /** URL da imagem ou vídeo do meme. */
    @Column(name = "url_midia", nullable = false, length = 2048)
    private String urlMidia;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;

    /** ID da categoria — referência lógica, validada via REST. */
    @Column(name = "categoria_id", nullable = false)
    private Long categoriaId;

    /** ID do usuário — referência lógica, validada via REST. */
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    public Meme() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getUrlMidia() { return urlMidia; }
    public void setUrlMidia(String urlMidia) { this.urlMidia = urlMidia; }

    public Date getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(Date dataCadastro) { this.dataCadastro = dataCadastro; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}

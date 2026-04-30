package br.com.ebac.animal_service.dto;

public class AnimalRecebedorDTO {
    private String nomeRecebedor;
    private Long quantidade;

    public AnimalRecebedorDTO(String nomeRecebedor, Long quantidade) {
        this.nomeRecebedor = nomeRecebedor;
        this.quantidade = quantidade;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void setNomeRecebedor(String nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
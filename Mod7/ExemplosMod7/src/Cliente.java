public class Cliente {

    private int codigo;

    private String nome;

    private String endereço;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public void cadastrarEndereço(String endereço) {
        setEndereço(endereço);
    }

    public void imprimirEndereço() {
        System.out.println(this.endereço);
    }

    public String retornarNomeCliente() {
        return "Endereço do Kadson";
    }

    public int getValorTotal() {
        return 20;
    }
}

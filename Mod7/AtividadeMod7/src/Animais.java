/**
 * @author Kadson Lima
 *
 */

public class Animais {


    //Atributos da classe
    String nome;
    String especie;
    int quantidade_de_patas;

    //Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getQuantidade_de_patas() {
        return quantidade_de_patas;
    }

    public void setQuantidade_de_patas(int quantidade_de_patas) {
        this.quantidade_de_patas = quantidade_de_patas;
    }

    //Método main para execução
    public static void main(String args[]){
        Animais a = new Animais();
        a.setQuantidade_de_patas(5);

        a.setNome("Leão");
        a.setEspecie("Mamíferos");
        a.setQuantidade_de_patas(4);

        System.out.println("O animal escolhido foi " + a.getNome());
        System.out.println("Ele é da especie dos " + a.getEspecie());
        System.out.println("E possui " + a.getQuantidade_de_patas() + " patas");


    }

}
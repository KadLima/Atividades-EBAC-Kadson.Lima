package Domain;

/**
 * Created by Kadson Lima on 13/11/2024
 *
 * @author Kadson Lima
 */
@Tabela(nomeDaTabela = "Domain.Alunos")

public class Alunos {
    private String nome;

    private float nota;

    public Alunos(String nome, float nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}

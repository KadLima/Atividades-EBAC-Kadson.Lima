package Main;

import Domain.Alunos;
import Domain.Tabela;

/**
 * Created by Kadson Lima on 13/11/2024
 *
 * @author Kadson Lima
 */
public class ProgramaTeste {
    public static void main(String[] args) {
        Alunos alunos = new Alunos("Kadson", 9.8F);
        Class<?> clazz = alunos.getClass();

        if(clazz.isAnnotationPresent(Tabela.class)){
            Tabela tabela = clazz.getAnnotation(Tabela.class);
            System.out.println("Nome da tabela: " + tabela.nomeDaTabela());
        } else{
            System.out.println("Tabela Não Encontrada");
        }
    }
}

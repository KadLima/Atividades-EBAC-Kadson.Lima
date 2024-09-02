package Exemplos;

import Domínios.Aluno;
import Domínios.ComparaNotaAluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Created by Kadson Lima on 01/09/2024
 *
 * @author Kadson Lima
 */
public class ExemploArrayListAlunos {
    public static void main(String[] args) {
        exemplosListaSimplesOrdenadaComparatorAluno();
        exemplosListaSimplesOrdenadaClasseExterna();
    }

    private static void exemplosListaSimplesOrdenadaClasseExterna () {
        System.out.println("***** Exemplo Lista Simples Ordenada Classe Externa *****");
        List<Aluno> listaAlunos = new ArrayList<Aluno>();

        Aluno a = new Aluno("Kadson Lima", "Análise e Desenvolvimento de Sistemas", 0);
        Aluno b = new Aluno("Mayara Letícia", "Fonoaudiologia0", 0);
        Aluno c = new Aluno("Adiel Macedo", "Educação Física", 0);
        listaAlunos.add(a);
        listaAlunos.add(b);
        listaAlunos.add(c);
        System.out.println(listaAlunos);
        Collections.sort(listaAlunos);
        System.out.println("Com o Collection" + listaAlunos);
        System.out.println("");

    }

    private static void exemplosListaSimplesOrdenadaComparatorAluno() {
        System.out.println("***** Exemplo Lista Simples Ordenada Comparator Aluno *****");
        List<Aluno> listaAluno2 = new ArrayList<Aluno>();

        Aluno a = new Aluno("Kadson Lima", "Análise e Desenvolvimento de Sistemas", 20);
        Aluno b = new Aluno("Mayara Letícia", "Fonoaudiologia0", 30);
        Aluno c = new Aluno("Adiel Macedo", "Educação Fisica", 10);
        listaAluno2.add(a);
        listaAluno2.add(b);
        listaAluno2.add(c);
        System.out.println(" ");
        System.out.println("Lista Sem Ordenação" + listaAluno2);
        Collections.sort(listaAluno2);
        System.out.println("Com o Collection" + listaAluno2);

        ComparaNotaAluno comparaNotaAluno = new ComparaNotaAluno();
        Collections.sort(listaAluno2, comparaNotaAluno);
        System.out.println("Com o Collection por nota" + listaAluno2);
        System.out.println(" ");
        }

    }
}
package Domínios;

import java.util.Comparator;

/**
 * Created by Kadson Lima on 01/09/2024
 *
 * @author Kadson Lima
 */
public class ComparaNotaAluno implements Comparator<Aluno> {

    @Override
    public int compare(Aluno o1, Aluno o2) {
        return Double.compare(o2.getNota(), o1.getNota());
    }
}

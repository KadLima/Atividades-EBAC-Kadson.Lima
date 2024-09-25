package Abstrata;

/**
 * Created by Kadson Lima on 17/09/2024
 *
 * @author Kadson Lima
 */
public class Programa {
    public static void main (String[] args) {
        Assalariado empregado = new Assalariado();
        empregado.setCpf("012345678910");
        empregado.setNome("Kadson");
        empregado.setSobrenome("Lima");
        empregado.setSalario(3450D);
        System.out.println(empregado.getNome() + " Tem Salário de: " + empregado.vencimento());
        imprimir(empregado);

        Comissionado empregado1 = new Comissionado();
        empregado1.setNome("Mayara");
        empregado1.setTaxaComissão(15D);
        empregado1.setTotalVenda(20D);
        System.out.println(empregado1.getNome() + " Recebe uma comissão de: " + empregado1.vencimento());
        imprimir(empregado1);

        Horista empregado3 = new Horista();
        empregado3.setNome("Kauã");
        empregado3.setPreçoHora(25D);
        empregado3.setTotalHorasTrabalhadas(27D);
        System.out.println(empregado3.getNome() + " Tem o salário de: " + empregado3.vencimento());
        imprimir(empregado3);
    }

    public static void imprimir(Empregado funcionário) {
        System.out.println(funcionário.getNome() + " Tem o salário de: " + funcionário.vencimento());
    }
}

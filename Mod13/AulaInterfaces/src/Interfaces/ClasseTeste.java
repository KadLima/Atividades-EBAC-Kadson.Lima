package Interfaces;

/**
 * Created by Kadson Lima on 16/09/2024
 *
 * @author Kadson Lima
 */
public class ClasseTeste {
    public static void main(String[] args) {
        ICaneta caneta = new CanetaEsferográfica();
        caneta.escrever("Olá Kadson");
        caneta.escreverComum();
        System.out.println(caneta.getCor());

        ICaneta giz = new Giz();
        giz.escrever("Olá Kadson");
        caneta.escreverComum();
        System.out.println(giz.getCor());

        ICaneta lapis = new Lapis();
        lapis.escrever("Olá Kadson");
        caneta.escreverComum();
        System.out.println(lapis.getCor());
    }
}

package Interfaces;

/**
 * Created by Kadson Lima on 16/09/2024
 *
 * @author Kadson Lima
 */
public class Lapis implements ICaneta{
    @Override
    public void escrever(String texto) {
        System.out.println("Escrevendo o valor  " + texto + " na classe " + getClass().getSimpleName());
    }

    @Override
    public String getCor() {
        return "Preto Claro";
    }
}

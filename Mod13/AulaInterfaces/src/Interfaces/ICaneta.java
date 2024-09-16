package Interfaces;

/**
 * Created by Kadson Lima on 16/09/2024
 *
 * @author Kadson Lima
 */
public interface ICaneta {
    public void escrever(String texto);

    public String getCor();

    default void escreverComum(){
        System.out.println("Escrita igual a todas");
    }

}

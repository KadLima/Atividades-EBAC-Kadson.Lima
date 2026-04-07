package Exercicio02;

public class Main {
    public static void main(String[] args) {
        Fila fila = new Fila(5);

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println("Front: " + fila.front());
        System.out.println("Rear: " + fila.rear());
        System.out.println("Tamanho: " + fila.size());

        System.out.println("Dequeue: " + fila.dequeue());
        System.out.println("Front agora: " + fila.front());
        System.out.println("Está vazia? " + fila.isEmpty());
    }
}

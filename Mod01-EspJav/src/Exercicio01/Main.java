package Exercicio01;

public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Topo: " + pilha.top());
        System.out.println("Tamanho: " + pilha.size());

        System.out.println("Pop: " + pilha.pop());
        System.out.println("Topo agora: " + pilha.top());

        System.out.println("Está vazia? " + pilha.isEmpty());
    }
}
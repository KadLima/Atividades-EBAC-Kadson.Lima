package Exercicio01;

public class Pilha {
    private int[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = new int[capacidade];
        topo = -1;
    }

    public void push(int valor) {
        if (topo + 1 >= elementos.length) {
            System.out.println("Pilha cheia!");
            return;
        }
        topo++;
        elementos[topo] = valor;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        int valor = elementos[topo];
        topo--;
        return valor;
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int size() {
        return topo + 1;
    }
}
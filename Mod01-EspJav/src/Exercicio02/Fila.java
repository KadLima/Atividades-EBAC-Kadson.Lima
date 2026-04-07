package Exercicio02;

public class Fila {
    private int[] elementos;
    private int frente;
    private int tras;
    private int tamanho;

    public Fila(int capacidade) {
        elementos = new int[capacidade];
        frente = 0;
        tras = -1;
        tamanho = 0;
    }

    public void enqueue(int valor) {
        if (tamanho >= elementos.length) return;
        tras = (tras + 1) % elementos.length;
        elementos[tras] = valor;
        tamanho++;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int valor = elementos[frente];
        frente = (frente + 1) % elementos.length;
        tamanho--;
        return valor;
    }

    public int rear() {
        if (isEmpty()) return -1;
        return elementos[tras];
    }

    public int front() {
        if (isEmpty()) return -1;
        return elementos[frente];
    }

    public int size() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}

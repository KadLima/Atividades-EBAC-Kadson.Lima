package Exercicio03;

public class LinkedList {
    private Node head;
    private int tamanho;

    public LinkedList() {
        head = null;
        tamanho = 0;
    }

    public void push(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node atual = head;
            while (atual.next != null) {
                atual = atual.next;
            }
            atual.next = node;
        }
        tamanho++;
    }

    public Node pop() {
        if (head == null) return null;
        if (head.next == null) {
            Node temp = head;
            head = null;
            tamanho--;
            return temp;
        }
        Node atual = head;
        while (atual.next.next != null) {
            atual = atual.next;
        }
        Node temp = atual.next;
        atual.next = null;
        tamanho--;
        return temp;
    }

    public void insert(int index, Node node) {
        if (index < 0 || index > tamanho) return;
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node atual = head;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.next;
            }
            node.next = atual.next;
            atual.next = node;
        }
        tamanho++;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) return;
        if (index == 0) {
            head = head.next;
        } else {
            Node atual = head;
            for (int i = 0; i < index - 1; i++) {
                atual = atual.next;
            }
            atual.next = atual.next.next;
        }
        tamanho--;
    }

    public Node elementAt(int index) {
        if (index < 0 || index >= tamanho) return null;
        Node atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.next;
        }
        return atual;
    }

    public int size() {
        return tamanho;
    }

    public void printList() {
        Node atual = head;
        StringBuilder sb = new StringBuilder();
        while (atual != null) {
            sb.append(atual.valor).append(" -> ");
            atual = atual.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}

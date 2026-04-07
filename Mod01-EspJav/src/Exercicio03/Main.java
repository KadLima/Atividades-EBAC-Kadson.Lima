package Exercicio03;

public class Main {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();

        lista.push(new Node(10));
        lista.push(new Node(20));
        lista.push(new Node(30));

        lista.printList();

        lista.insert(1, new Node(15));
        lista.printList();

        lista.remove(2);
        lista.printList();

        Node n = lista.pop();
        System.out.println("Pop: " + n.valor);

        System.out.println("Elemento no índice 1: " + lista.elementAt(1).valor);
        System.out.println("Tamanho: " + lista.size());
    }
}

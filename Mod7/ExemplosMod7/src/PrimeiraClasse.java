public class PrimeiraClasse {

    public static void main(String args[]) {
        System.out.println("Olá Kadson Lima");
        Cliente cliente = new Cliente();
        cliente.cadastrarEndereço("Rua 1");
        cliente.setCodigo(1);
        System.out.println(cliente.getCodigo());
        cliente.imprimirEndereço();
        String end = cliente.retornarNomeCliente();
        System.out.println(end);
        System.out.println(cliente.getValorTotal());
    }
}

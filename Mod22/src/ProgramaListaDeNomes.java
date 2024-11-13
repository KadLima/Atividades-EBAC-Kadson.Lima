import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Kadson Lima on 13/11/2024
 *
 * @author Kadson Lima
 */
public class ProgramaListaDeNomes {
    public static void main(String[] args) {
        List<String> listaNomesMasculinos = new ArrayList<>();
        List<String> listaNomesFemininos = new ArrayList<>();

        Scanner respostas = new Scanner(System.in);

        while (true) {
            System.out.print("Digite o nome que você deseja adicionar na lista | Seguindo o seguinte exemplo: Kadson - Masculino | Ou digite Sair: ");
            String nomesParaLista = respostas.nextLine();
            if (nomesParaLista.equalsIgnoreCase("Sair")) {
                System.out.println();
                System.out.println("Certo. Finalizando o programa.");
                break;
            }
            String[] partes = nomesParaLista.split("-");
            if (partes.length != 2) {
                System.out.println();
                System.out.println("Formato Inválido. Tente seguindo o exemplo: Nome - Gênero");
                System.out.println();
                continue;
            }

            String nome = partes[0].trim();
            String genero = partes[1].trim();

            if (genero.equalsIgnoreCase("Masculino")) {
                listaNomesMasculinos.add(nome);
                System.out.println();
                System.out.println("Nome Masculino adicionado com sucesso! ");
            } else if (genero.equalsIgnoreCase("Feminino")) {
                listaNomesFemininos.add(nome);
                System.out.println();
                System.out.println("Nome Feminino adicionado com sucesso! ");
            } else {
                System.out.println();
                System.out.println("Opção Inválida. Use Masculino ou Feminino");
                System.out.println();
                continue;
            }

            System.out.println();
            System.out.print("Você gostaria de ver os dados que foram armazenados? (Sim/Não) ");
            String opção = respostas.nextLine();

            if (opção.equalsIgnoreCase("Sim")) {
                exibirLista("Masculino", listaNomesMasculinos);
                exibirLista("Feminino", listaNomesFemininos);

                List<String> mulheres = listaNomesFemininos.stream().filter(nomeFeminino -> nomeFeminino.length() > 0).collect(Collectors.toList());
                System.out.println("\nLista com apenas os nomes Femininos: ");
                mulheres.forEach(System.out::println);
                System.out.println();

                System.out.print("Você gostaria de adicionar mais algum nome?(Sim/Não) ");
                String opção1 = respostas.nextLine();
                if (opção1.equalsIgnoreCase("Não")) {
                    System.out.println();
                    System.out.println("Certo. Finalizando o programa.");
                    break;
                }
                System.out.println();
            }
        }

    }

    private static void exibirLista(String genero, List<String> lista) {
        System.out.println("\nNomes " + genero + ":");
        for (String nome : lista) {
            System.out.println(nome);
        }
        System.out.println();
    }


}

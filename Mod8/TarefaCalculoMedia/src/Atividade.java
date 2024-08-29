public class Atividade {

    float Nota1 = 8.5f;
    float Nota2 = 7.7f;
    float Nota3 = 9.2f;
    float Nota4 = 8.9f;

    public static void main(String[] args) {
        Atividade nota = new Atividade();
        System.out.println((nota.Nota1 + nota.Nota2 + nota.Nota3 + nota.Nota4) / 4);
    }
}
public class TestesAula {

    static int num1 = 5;
    static int num2 = 10;
    static int num3 = -2;
    static int num4 = 7;

    public static void main(String[] args) {
        System.out.println("Operações Aritmeticas");
        System.out.println((num1) + (num2));
        System.out.println((num3) + (num4));
        System.out.println((num1) + (num4));
        System.out.println((num2) + (num3));
        System.out.println((num1) * (num3));
        System.out.println((num1) / (num2));

        operaçõesIncrementoDecremento();
        operaçõesRelacionais();

    }



    public static void operaçõesIncrementoDecremento() {
        int numero1 = 25;
        ++numero1;
        System.out.println("Operações Incremento e Decremento: ");
        System.out.println(numero1);
    }

    public static void operaçõesRelacionais() {
        int num1 = 22;
        int num2 = 22;

        System.out.println("Operações Relacionais");

        boolean Maiorq = num1 > num2;
        System.out.println("Maiorq = " + Maiorq);

        boolean Menorq = num1 < num2;
        System.out.println("Menorq = " + Menorq);

        boolean EqualA = num1 == num2;
        System.out.println("EqualA = " + EqualA);

        boolean DifeA = num1 != num2;
        System.out.println("DifeA = " + DifeA);


        System.out.println("Operadores Lógicos");

        boolean EstaDentro = num1 >= 0 && num1 <= 25;
        System.out.println("EstáDentro = " + EstaDentro);

        boolean EstaDentro2 = num1 >= 0 || num1 <= 10;
        System.out.println("EstáDentro2 = " + EstaDentro2);

        boolean not = num1 >= 0 || num1 <= 10;
        System.out.println("Not = " + !not);
    }
}
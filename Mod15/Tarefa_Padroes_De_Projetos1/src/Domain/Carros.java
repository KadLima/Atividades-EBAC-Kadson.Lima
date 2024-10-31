package Domain;

/**
 * Created by Kadson Lima on 15/10/2024
 *
 * @author Kadson Lima
 */
public abstract class Carros {
    private int potênciaHP;
    private String tipoDeMotor;
    private String corDoVeículo;

    public Carros(int potênciaHP, String tipoDeMotor, String corDoVeículo) {
        this.potênciaHP = potênciaHP;
        this.tipoDeMotor = tipoDeMotor;
        this.corDoVeículo = corDoVeículo;
    }

    public void partidaDoMotor() {
        System.out.println("O motor foi ligado e está pronto para ser utilizado. O motor possui " + potênciaHP + "HP de potência.");
    }

    public void verificaçãoDeLimpeza() {
        System.out.println("O carro está limpo, e a cor " + corDoVeículo + " está mais brilhante do quê nunca.");
    }

    public void avaliaçãoMecânica() {
        System.out.println("O carro foi verificado pelos mecânicos e tudo parece estar fluindo perfeitamente.");
    }


    public void abastecer() {
        System.out.println("O carro está sendo abastecido com " + tipoDeMotor);
    }
}

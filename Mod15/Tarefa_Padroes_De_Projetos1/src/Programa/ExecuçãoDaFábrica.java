package Programa;

import Domain.*;

/**
 * Created by Kadson Lima on 30/10/2024
 *
 * @author Kadson Lima
 */
public class ExecuçãoDaFábrica {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("A", true);
        FábricaDeCarros fábrica = getFábrica(cliente);
        Carros carros = fábrica.criar(cliente.getTipoDeSolicitação());
        carros.partidaDoMotor();
    }

    private static FábricaDeCarros getFábrica(Cliente cliente) {
        if (cliente.tipoDeContratoDaEmpresa()){
            return new ContratosDaFábrica();
        } else{
            return new SemContratoFábrica();
        }
    }
}

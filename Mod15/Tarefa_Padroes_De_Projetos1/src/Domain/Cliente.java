package Domain;

/**
 * Created by Kadson Lima on 30/10/2024
 *
 * @author Kadson Lima
 */
public class Cliente {
    private String tipoDeSolicitação;
    private boolean tipoDeContratoDaEmpresa;

    public Cliente(String tipoDeSolicitação, boolean tipoDeContratoDaEmpresa){
        this.tipoDeSolicitação = tipoDeSolicitação;
        this.tipoDeContratoDaEmpresa = tipoDeContratoDaEmpresa;
    }

    public boolean tipoDeContratoDaEmpresa(){
        return tipoDeContratoDaEmpresa;
    }

    public String getTipoDeSolicitação() {
        return tipoDeSolicitação;
    }
}

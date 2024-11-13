import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kadson Lima on 13/11/2024
 *
 * @author Kadson Lima
 */
public class ProgramaListaDeNomesTest {
    @Test
    public void testarListaDeNomesFemininos() {
        List<String> listaDeNomesMasculinos = new ArrayList<>();
        List<String> listaDeNomesFemininos = new ArrayList<>();

        listaDeNomesFemininos.add("Ana");
        listaDeNomesFemininos.add("Maria");
        listaDeNomesMasculinos.add("Kadson");

        List<String> listaFemininasFiltradas = listaDeNomesFemininos.stream().filter(nome -> nome != null && !nome.isEmpty()).toList();

        assertEquals("A lista de mulheres deve conter 2 nomes.", 2, listaFemininasFiltradas.size());
        assertTrue("A lista deve conter o nome Maria.", listaFemininasFiltradas.contains("Maria"));
        assertTrue("A lista deve conter o nome Ana.", listaFemininasFiltradas.contains("Ana"));
        assertFalse("A lista não deve conter o nome Kadson.", listaFemininasFiltradas.contains("Kadson"));


    }
}

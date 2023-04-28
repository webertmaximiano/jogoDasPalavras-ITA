package Testes;

import EmbaralharPalavras.Embaralhador;
import EmbaralharPalavras.FabricaDeEmbaralhadores;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.String;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TesteEmbaralharPalavras {
    Random random;
    FabricaDeEmbaralhadores fabricaDeEmbaralhadores = new FabricaDeEmbaralhadores();
    String palavra = "exemplo";

    @Test
    public void testeEmbaralhar() {
        String embaralhada = fabricaDeEmbaralhadores.embaralhar(palavra);
        System.out.println(embaralhada);
        assertNotEquals(palavra, embaralhada); //palavra precisa vim embaralhada não pode ser igual.
    }

    @Test
    public void testeEmbaralhador() {
        String embaralhada = fabricaDeEmbaralhadores.embaralhador(palavra);
        System.out.println(embaralhada);
        assertNotEquals(palavra, embaralhada); //palavra precisa vim embaralhada não pode ser igual.

    }

    @Test
    public void testeEmbaralhadorInverso(){
        String embaralhada = fabricaDeEmbaralhadores.embaralharInverso(palavra);
        System.out.println(embaralhada);
        assertEquals("olpmexe", embaralhada); //palavra precisa vim embaralhada invertida.
    }

    @Test
    public void testeEmbaralharParesDepoisImpares() {
        String embaralhada = fabricaDeEmbaralhadores.embaralharParesDepoisImpares(palavra);
        System.out.println(embaralhada);
        assertEquals("eepoxml", embaralhada); //
    }

}

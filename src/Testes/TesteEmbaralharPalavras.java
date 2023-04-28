package Testes;

import EmbaralharPalavras.EmbaralharAleatório;
import EmbaralharPalavras.EmbaralharInverso;
import EmbaralharPalavras.EmbaralharPrimeiroParDepoisImpar;
import EmbaralharPalavras.FabricaDeEmbaralhadores;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TesteEmbaralharPalavras {
        Random random;
        FabricaDeEmbaralhadores fabricaDeEmbaralhadores = new FabricaDeEmbaralhadores();
        EmbaralharInverso embaralharInverso = new EmbaralharInverso();
        EmbaralharAleatório embaralharAleatório = new EmbaralharAleatório();
        EmbaralharPrimeiroParDepoisImpar embaralharParesDepoisImpares = new EmbaralharPrimeiroParDepoisImpar();
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
        String embaralhada = embaralharInverso.embaralhar(palavra);
        System.out.println(embaralhada);
        assertEquals("olpmexe", embaralhada); //palavra precisa vim embaralhada invertida.
    }

    @Test
    public void testeEmbaralharParesDepoisImpares() {
        String embaralhada = embaralharParesDepoisImpares.embaralhar(palavra);
        System.out.println(embaralhada);
        assertEquals("eepoxml", embaralhada); //
    }

}

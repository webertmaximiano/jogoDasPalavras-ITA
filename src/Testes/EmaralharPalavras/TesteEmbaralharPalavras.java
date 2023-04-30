package Testes.EmaralharPalavras;

import EmbaralharPalavras.EmbaralharAleatório;
import EmbaralharPalavras.EmbaralharInverso;
import EmbaralharPalavras.EmbaralharPrimeiroParDepoisImpar;
import EmbaralharPalavras.FabricaDeEmbaralhadores;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TesteEmbaralharPalavras {
        // Antes de realizar o Teste carrega o Setup
        Random random;
        FabricaDeEmbaralhadores fabricaDeEmbaralhadores = new FabricaDeEmbaralhadores();
        EmbaralharInverso embaralharInverso = new EmbaralharInverso();
        EmbaralharAleatório embaralharAleatório = new EmbaralharAleatório();
        EmbaralharPrimeiroParDepoisImpar embaralharParesDepoisImpares = new EmbaralharPrimeiroParDepoisImpar();

        String palavra = "exemplo";

    @Test // testando o metodo embaralhar() da FabricaDeEmbaralhadores
    public void testeEmbaralhar() {

        String embaralhada = fabricaDeEmbaralhadores.embaralhar(palavra);
        System.out.println(embaralhada);
        //palavra precisa vim embaralhada não pode ser igual.
        assertNotEquals(palavra, embaralhada);
    }

    @Test // testando o metodo embaralhardor() da FabricaDeEmbaralhadores
    public void testeEmbaralhador() {
        String embaralhada = fabricaDeEmbaralhadores.embaralhador(palavra);
        System.out.println(embaralhada);
        //palavra precisa vim embaralhada não pode ser igual.
        assertNotEquals(palavra, embaralhada);

    }

    @Test // testando o EmbaralharInverso
    public void testeEmbaralhadorInverso(){
        String embaralhada = embaralharInverso.embaralhar(palavra);
        System.out.println(embaralhada);
        //palavra precisa vim embaralhada invertida.
        assertEquals("olpmexe", embaralhada);
    }

    @Test //testando EmbaralharPrimeiroParDepoisImpar
    public void testeEmbaralharParesDepoisImpares() {
        String embaralhada = embaralharParesDepoisImpares.embaralhar(palavra);
        System.out.println(embaralhada);
        // cada letra recebe um indice 0e 1x  2e 3m 4p 5l 6o, pares+impares 0246135
        assertEquals("eepoxml", embaralhada);
    }

}

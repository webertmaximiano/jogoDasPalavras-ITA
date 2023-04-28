package Testes;

import FontePalavras.BancoDePalavras;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.String;
import java.util.List;

public class TesteFontePalavras {

    private static BancoDePalavras banco;

    @BeforeAll
    public static void setup() {
        banco = new BancoDePalavras("F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"); // substitua pelo caminho do seu arquivo
    }
    @Test
    public void testGetPalavraAleatoria() {
        String palavra = banco.getPalavraAleatoria();
        System.out.println(palavra);
        List<String> palavras = banco.getPalavras();
        Assertions.assertTrue(palavras.contains(palavra)); // verifica se a palavra está na lista de palavras
    }
}


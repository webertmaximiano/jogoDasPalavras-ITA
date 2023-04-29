package Testes;

import EmbaralharPalavras.FabricaDeEmbaralhadores;
import FontePalavras.BancoDePalavras;
import Jogo.FabricaMecanicaDeJogo;
import Jogo.MecanicaDoJogo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteErrouAcabou {
    private static BancoDePalavras banco;
    //private static FabricaMecanicaDeJogo jogo;
    private static FabricaDeEmbaralhadores embaralhador;
    @BeforeAll
    public static void setup() {
        banco = new BancoDePalavras("F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"); // substitua pelo caminho do seu arquivo
        MecanicaDoJogo jogo = FabricaMecanicaDeJogo.getJogo(1);
        embaralhador = new FabricaDeEmbaralhadores();
        Scanner in = new Scanner(System.in);
    }
    @Test
    public void testeRespostaDaVez(){
        MecanicaDoJogo jogo = FabricaMecanicaDeJogo.getJogo(1);
        String palavra = "flamengo";
        String embaralhada = "ognemalf";
        String resposta = "flamengo";
        String resultado = jogo.respostaDaVez(palavra, resposta);
        assertEquals("flamengo", "flamengo");
    }
}

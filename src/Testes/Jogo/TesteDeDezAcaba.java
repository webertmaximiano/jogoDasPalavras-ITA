package Testes.Jogo;

import EmbaralharPalavras.FabricaDeEmbaralhadores;
import FontePalavras.BancoDePalavras;
import Jogo.DeDezAcaba;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteDeDezAcaba {
    private static BancoDePalavras banco;
    private static FabricaDeEmbaralhadores embaralhador;

    private static DeDezAcaba jogo;


    @BeforeEach
    public void setup() {
        banco = new BancoDePalavras("F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"); // substitua pelo caminho do seu arquivo
        //MecanicaDoJogo mecanicaDoJogo = FabricaMecanicaDeJogo.getJogo(3); // 1 Errou Acabaou - 2 Cinco Chances - 3 De Dez Acaba
        jogo = new DeDezAcaba();
        embaralhador = new FabricaDeEmbaralhadores();


    }
    @Test
    public void testeRespostaDaVez(){
        while (!jogo.acabouJogo()) {
            String nomeDoJogo = jogo.modoDeJogo();
            System.out.println("Nome do Jogo: "+nomeDoJogo);
            String palavra = banco.getPalavraAleatoria();
            System.out.println("Palavra Sorteada: "+palavra);
            String embaralhada = embaralhador.embaralhar(palavra);
            System.out.println("Palavra Embaralhada: "+embaralhada);
            String resposta = palavra;
            String resultado = jogo.respostaDaVez(palavra, resposta);
            Boolean acertou = jogo.acertouResposta();
            String resultadoFinal = jogo.resultadoFinal();
            System.out.println("Resultado Final: "+resultadoFinal+"\n");

        }
        assertEquals("Você realizou 5 Tentativas e Marcou 10 pontos", jogo.resultadoFinal());
    }

}

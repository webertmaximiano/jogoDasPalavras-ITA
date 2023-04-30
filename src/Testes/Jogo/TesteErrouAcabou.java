package Testes.Jogo;

import EmbaralharPalavras.FabricaDeEmbaralhadores;
import FontePalavras.BancoDePalavras;
import Jogo.ErrouAcabou;
import Jogo.FabricaMecanicaDeJogo;
import Jogo.MecanicaDoJogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteErrouAcabou {
    private static BancoDePalavras banco;
    private static FabricaDeEmbaralhadores embaralhador;

    private static ErrouAcabou jogo;


    @BeforeEach
    public void setup() {
        banco = new BancoDePalavras("F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"); // substitua pelo caminho do seu arquivo
        MecanicaDoJogo modoDeJogo = FabricaMecanicaDeJogo.getJogo(1); // 1 Errou Acabaou - 2 Cinco Chances - 3 De Dez Acaba
        jogo = new ErrouAcabou();
        embaralhador = new FabricaDeEmbaralhadores();
    }
    @Test
    public void testeRespostaDaVez(){
        String nomeDoJogo = jogo.modoDeJogo();
        System.out.println("Nome do Jogo: "+nomeDoJogo);
        String palavra = banco.getPalavraAleatoria();
        System.out.println("Palavra Sorteada: "+palavra);
        String embaralhada = embaralhador.embaralhar(palavra);
        System.out.println("Palavra Embaralhada: "+embaralhada);
        String resposta = palavra;
        String resultado = jogo.respostaDaVez(palavra, resposta);
        assertEquals(palavra, resposta);
    }
}

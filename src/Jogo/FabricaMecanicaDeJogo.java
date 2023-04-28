package Jogo;

import EmbaralharPalavras.Embaralhador;
import FontePalavras.BancoDePalavras;

public abstract class FabricaMecanicaDeJogo implements MecanicaDoJogo {

    private BancoDePalavras bancoDePalavras;
    private Embaralhador embaralhador;
    private int tentativas = 5;
    private int pontos = 0;

    //construtor FabricaMecanicaDeJogo
    public FabricaMecanicaDeJogo(BancoDePalavras bancoDePalavras, Embaralhador embaralhador) {
        this.bancoDePalavras = bancoDePalavras;
        this.embaralhador = embaralhador;
    }
/*
    // Método para jogar adivinhando a palavra embaralhada
    public String jogarAdivinhandoPalavraEmbaralhada() {
        int pontos = 0;
        String palavra = bancoDePalavras.getPalavraAleatoria();
        String palavraEmbaralhada = embaralhador.embaralhar(palavra);
        System.out.println("A palavra embaralhada é: " + palavraEmbaralhada);
        String resposta = System.console().readLine("Qual é a palavra? ");
        if (resposta.equals(palavra)) {
            System.out.println("Parabéns, você acertou!");
            pontos++;
        } else {
            System.out.println("Que pena, você errou!");
        }
        System.out.println("Você marcou " + pontos + " ponto(s)!");

    }

    // Método para jogar adivinhando a palavra original
    public String jogarAdivinhandoPalavraOriginal() {
        int pontos = 0;
        String palavra = bancoDePalavras.getPalavraAleatoria();
        String resposta = System.console().readLine("Qual é a palavra? ");
        if (resposta.equals(palavra)) {
            System.out.println("Parabéns, você acertou!");
            pontos++;
        } else {
            System.out.println("Que pena, você errou!");
            tentativas--;
        }
        System.out.println("Você marcou " + pontos + " ponto(s)!");

    }


    public String ModoDeJogo(int num) {

        String mensagem = "Digite uma Opção Válida 1 ou 2";
        if (num == 1) {
            jogarAdivinhandoPalavraEmbaralhada();
        }  else if (num == 2) {
            jogarAdivinhandoPalavraOriginal();
        }else {
            return mensagem;
        }
    }

    @Override
    public Boolean acabouJogo() {
        return null;
    }

    @Override
    public Boolean acertouResposta() {
        return null;
    }

    @Override
    public int tentativas() {
        return tentativas;
    }

    @Override
    public int pontos() {
        return pontos;
    }

 */
}

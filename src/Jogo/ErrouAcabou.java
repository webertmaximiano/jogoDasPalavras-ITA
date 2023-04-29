package Jogo;

import FontePalavras.BancoDePalavras;

public class ErrouAcabou implements MecanicaDoJogo{

    private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo
    private boolean errou = false;
    private int pontos = 0;

    private int tentativas =0;
    private BancoDePalavras banco = new BancoDePalavras(arquivo);
    @Override
    public String modoDeJogo() {
        return "Errou Acabou!";
    }

    @Override
    public String instrucoes() {
        return "Digite a Palavra Certa e Ganhe Pontos, erre e o jogo acaba!";
    }

    @Override
    public Boolean acabouJogo() {
        return errou;
    }

    @Override
    public String palavraDaVez() {
        return banco.getPalavraAleatoria();
    }

    @Override
    public Boolean acertouResposta() {
        return true;
    }

    @Override
    public int tentativas() {
        return tentativas;
    }

    @Override
    public int pontos() {
        return pontos;
    }

    @Override
    public String respostaDaVez(String palavra, String resposta) {
        if (palavra.equals(resposta)){
            tentativas+=1;
            pontos+=2;
            return "Resposta Correta! Vamos pra Próxima!";
        }else {
            errou = true;
            return "Resposta Errada! Acabou o Jogo!";
        }

    }

    @Override
    public String resultadoFinal() {
        return "Você realizou "+tentativas+" Tentativas e Marcou "+pontos+" pontos";
    }
}

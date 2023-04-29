package Jogo;

import FontePalavras.BancoDePalavras;

public class DeDezAcaba implements MecanicaDoJogo{
    private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo

    private boolean terminou = false;
    private int pontos = 0;
    private int tentativas =0;
    private BancoDePalavras banco = new BancoDePalavras(arquivo);
    @Override
    public String modoDeJogo() {
        return "De Dez Acaba!";
    }
    @Override
    public String instrucoes() {
        return "Você tem que Somar 10 Pontos, caso contrário vai ficar tentando! ";
    }

    @Override
    public Boolean acabouJogo() {
        return terminou;
    }

    @Override
    public String palavraDaVez() {
        return banco.getPalavraAleatoria();
    }

    @Override
    public Boolean acertouResposta() {
        if ( pontos >= 10) {
            return terminou = true;
        } else {
            return terminou = false;
        }
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

        if (palavra.equals(resposta) ){
            tentativas+=1;
            pontos+=2;
            return "Resposta Correta! Vamos pra Próxima!";
        }else {
            tentativas+=1;
            return "Resposta Errada! Tente Outra vez!";
        }

    }

    @Override
    public String resultadoFinal() {
        return "Você realizou "+tentativas+" Tentativas e Marcou "+pontos+" pontos";
    }
}

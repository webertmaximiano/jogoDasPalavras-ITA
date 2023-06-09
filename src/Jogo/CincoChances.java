package Jogo;

import FontePalavras.BancoDePalavras;

public class CincoChances implements MecanicaDoJogo {

    private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo

    private boolean gameover = false;
    private int pontos = 0;
    private int tentativas =0;
    private boolean passouDeFase= false;
    private String resultadoRespostaDavez;
    private BancoDePalavras banco = new BancoDePalavras(arquivo);
    @Override
    public String modoDeJogo() {
        return "Cinco Chances!";
    }
    @Override
    public String instrucoes() {
        return "Você tem 5 Chances! Passa de Fase se Somar mais de 8 Pontos";
    }

    @Override
    public Boolean acabouJogo() {
        return gameover;
    }

    @Override
    public String palavraDaVez() {
        return banco.getPalavraAleatoria();
    }

    @Override
    public Boolean acertouResposta() {

        if (tentativas == 5 && pontos > 8) {
            tentativas=0;
            pontos =0;
            passouDeFase = true;
            return gameover = false;
        } else {
            while (tentativas == 5 && pontos <8)
            return gameover = true;
        }
        return gameover;
    }

    @Override
    public String respostaDaVez(String palavra, String resposta) {

        if (palavra.equals(resposta) ){
            tentativas+=1;
            pontos+=2;
            return resultadoRespostaDavez = "Resposta Correta! Vamos pra Próxima!";
        }else {
            tentativas+=1;
            return resultadoRespostaDavez = "Resposta Errada! Tente Outra vez!";
        }

    }

    @Override
    public String passouDeFase() {
        if (passouDeFase) {
            return "Você Passou de Fase!";
        } else if (passouDeFase == false && gameover == true) {
            return "Você não Passou de Fase!";
        } else {
            return "Próxima tentativa.";
        }
    }

    @Override
    public String resultadoFinal() {
        return "Você realizou "+tentativas+" Tentativas e Marcou "+pontos+" pontos";
    }
}

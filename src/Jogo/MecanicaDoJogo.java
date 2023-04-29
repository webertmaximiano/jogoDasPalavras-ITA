package Jogo;

public interface MecanicaDoJogo {
    public String modoDeJogo();
    public String instrucoes();
    public Boolean acabouJogo();
    public String palavraDaVez();

    public Boolean acertouResposta();
    public int tentativas();
    public int pontos();

    String respostaDaVez(String palavra, String resposta);

    public String resultadoFinal();
}

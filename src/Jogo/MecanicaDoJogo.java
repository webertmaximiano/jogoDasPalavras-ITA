package Jogo;

public interface MecanicaDoJogo {
    public String modoDeJogo();
    public String instrucoes();
    public Boolean acabouJogo();
    public String palavraDaVez();
    public Boolean acertouResposta();
    String respostaDaVez(String palavra, String resposta);
    public String resultadoFinal();
    public String passouDeFase();

}

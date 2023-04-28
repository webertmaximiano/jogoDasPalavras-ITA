package Jogo;

public interface MecanicaDoJogo {
    public String ModoDeJogo();
    public Boolean acabouJogo();
    public Boolean acertouResposta();
    public int tentativas();
    public int pontos();
}

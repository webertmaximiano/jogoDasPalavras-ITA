package Jogo;

public interface MecanicaDoJogo {
    public String getNome();
    public Boolean acabouJogo();
    public Boolean acertouResposta();
    public int tentativas();
    public int pontos();
}

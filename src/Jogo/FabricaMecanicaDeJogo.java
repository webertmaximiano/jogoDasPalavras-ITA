package Jogo;

public class FabricaMecanicaDeJogo  {
    public static MecanicaDoJogo getJogo(int opcao) {
        if (opcao == 1) {
            return new ErrouAcabou();
        } else if (opcao == 2) {

            return new CincoChances();
        } else {
            return new DeDezAcaba();
        }
    }

}

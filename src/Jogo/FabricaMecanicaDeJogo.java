package Jogo;

import java.util.Random;
public class FabricaMecanicaDeJogo {

    public static MecanicaDoJogo getJogo(int opcao) {
        switch (opcao) {
            case 1:
                return new ErrouAcabou();
            case 2:
                return new CincoChances();
            case 3:
                return new DeDezAcaba();
            case 4:
                return Aleatorio();
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }

    private static MecanicaDoJogo Aleatorio() {
        Random random = new Random();
        int opcao = random.nextInt(3);
        if (opcao == 0) {
            return new ErrouAcabou();
        } else if (opcao == 1) {
            return new CincoChances();
        } else {
            return new DeDezAcaba();
        }
    }
}

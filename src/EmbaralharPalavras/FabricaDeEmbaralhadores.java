package EmbaralharPalavras;

import java.util.Random;

public class FabricaDeEmbaralhadores implements Embaralhador{

    private Random random;

    public FabricaDeEmbaralhadores() { //inicializa o construtor pra fornecer um método aleatório
        this.random = new Random();
    }

    @Override //implementação do metodo embaralhador embaralhar
    public String embaralhar(String palavra) {
        String palavraEmbaralhada = embaralhador(palavra);
        return palavraEmbaralhada;
    }

    public String embaralhador(String palavra) {
        // Escolhe um dos métodos de embaralhamento aleatoriamente
        int opcao = random.nextInt(3);
        if (opcao == 0) {
            EmbaralharAleatório aleatorio = new EmbaralharAleatório();
            return aleatorio.embaralhar(palavra);
        } else if (opcao == 1) {
            EmbaralharInverso inverso = new EmbaralharInverso();
            return inverso.embaralhar(palavra);
        } else {
            EmbaralharPrimeiroParDepoisImpar parDepoisImpar = new EmbaralharPrimeiroParDepoisImpar();
            return parDepoisImpar.embaralhar(palavra);
        }
    }
}

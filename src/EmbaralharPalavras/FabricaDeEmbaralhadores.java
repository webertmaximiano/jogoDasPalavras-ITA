package EmbaralharPalavras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
            return embaralharAleatorio(palavra);
        } else if (opcao == 1) {
            return embaralharInverso(palavra);
        } else {
            return embaralharParesDepoisImpares(palavra);
        }
    }

    private String embaralharAleatorio(String palavra) { //recebe a palavra e retorna embaralhada de forma aleatória
        List<Character> caracteres = new ArrayList<>();
        for (char c : palavra.toCharArray()) {
            caracteres.add(c);
        }
        Collections.shuffle(caracteres);
        StringBuilder sb = new StringBuilder();
        for (char c : caracteres) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String embaralharInverso(String palavra) { // recebe a palavra e retorna invertida
        return new StringBuilder(palavra).reverse().toString();
    }

    public String embaralharParesDepoisImpares(String palavra) { // recebe a palavra e embaralha pelo indice do array impares na frente e pares depois
        char[] caracteres = palavra.toCharArray();
        List<Character> impares = new ArrayList<>();
        List<Character> pares = new ArrayList<>();
        for (int i = 0; i < caracteres.length; i++) {
            if (i % 2 == 0) {
                pares.add(caracteres[i]);
            } else {
                impares.add(caracteres[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : pares) {
            sb.append(c);
        }
        for (char c : impares) {
            sb.append(c);
        }
        return sb.toString();
    }
}

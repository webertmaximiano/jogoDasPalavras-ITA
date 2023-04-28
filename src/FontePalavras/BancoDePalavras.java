package FontePalavras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Classe Responsável por fornecer palavras ao Jogo, ela vai extrair palavras de um arquivo
// e colocar em uma Lista, oferecendo um método para devolver uma palavra
public class BancoDePalavras {
    private List<String> palavras; //Atributo lista de palavras

    public BancoDePalavras(String arquivo) { //construtor da Lista de Palavras
        this.palavras = lerArquivo(arquivo);
    }

    private List<String> lerArquivo(String arquivo) { //metodo que lê o Arquivo e coloca as palavras em uma lista
        List<String> palavras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha; //armazenar a linha lida
            while ((linha = br.readLine()) != null) {
                palavras.add(linha); //coloca a linha na lista de palavras
            }
        } catch (IOException e) { // bloco try/catch trata possíveis erros.
            System.err.println("Erro ao ler o arquivo " + arquivo + ": " + e.getMessage());
        }
        return palavras;
    }

    public String getPalavraAleatoria() { //método que devolve uma palavra aleatória
        Random random = new Random();
        int indiceAleatorio = random.nextInt(this.palavras.size());
        return this.palavras.get(indiceAleatorio);
    }
    public List<String> getPalavras() {
        return this.palavras;
    }
}

import EmbaralharPalavras.FabricaDeEmbaralhadores;
import FontePalavras.BancoDePalavras;
import Jogo.FabricaMecanicaDeJogo;
import Jogo.MecanicaDoJogo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo

        BancoDePalavras banco = new BancoDePalavras(arquivo);
        FabricaDeEmbaralhadores embaralhador = new FabricaDeEmbaralhadores();
        Scanner in = new Scanner(System.in);

        System.out.println("##### Jogo das Palavras - por Webert Maximiano ##### \n");
        System.out.println("Selecione o modo de Jogo:");
        System.out.println("Digite 1 - Errou Acaba, 2 - Cinco Chances, 3 - De Dez Acaba");
        int opcao = Integer.parseInt(in.nextLine());
        MecanicaDoJogo mecanicaDoJogo = FabricaMecanicaDeJogo.getJogo(opcao);

        System.out.println(" Modo de Jogo : "+ mecanicaDoJogo.modoDeJogo());
        System.out.println("Como Jogar: " + mecanicaDoJogo.instrucoes());

        while (!mecanicaDoJogo.acabouJogo()){
            String palavra = mecanicaDoJogo.palavraDaVez();
            String embaralhada = embaralhador.embaralhar(palavra);
            System.out.println("Decifre a Palavra: " + embaralhada);
            String resposta = in.nextLine();
            String resultado = mecanicaDoJogo.respostaDaVez(palavra, resposta);
            System.out.println(resultado);
            mecanicaDoJogo.acertouResposta();
        }

        System.out.println(mecanicaDoJogo.resultadoFinal());
    }
}
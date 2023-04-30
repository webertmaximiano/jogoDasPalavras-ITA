import EmbaralharPalavras.FabricaDeEmbaralhadores;
import FontePalavras.BancoDePalavras;
import Jogo.FabricaMecanicaDeJogo;
import Jogo.MecanicaDoJogo;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
                            // substitua pelo caminho do seu arquivo
        String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt";

        // carrega o banco de palavras
        BancoDePalavras banco = new BancoDePalavras(arquivo);

        // instancia a Fabrica de Embaralhadores
        FabricaDeEmbaralhadores embaralhador = new FabricaDeEmbaralhadores();

        //inicia o Leitor de entrada de resposta no console
        Scanner in = new Scanner(System.in);

        // informações iniciais no console
        System.out.println("##### Jogo das Palavras - por Webert Maximiano ##### \n");
        System.out.println("Selecione o modo de Jogo: ");
        System.out.println("Digite 1-Errou Acaba, 2-Cinco Chances, 3-De Dez Acaba, 4-Aleatório \n");

        //armazena a opção digitada para ser passada como paramentro pra mecânica do jogo
        int opcao = Integer.parseInt(in.nextLine());

        //inicia o jogo através da mecânica de jogo escolhida pelo usuário
        MecanicaDoJogo mecanicaDoJogo = FabricaMecanicaDeJogo.getJogo(opcao);

        // informa o modo de jogo que foi selecionado e as instruções de jogo
        System.out.println("Modo de Jogo : "+ mecanicaDoJogo.modoDeJogo());
        System.out.println("Como Jogar: " + mecanicaDoJogo.instrucoes());

        // Enquanto a Mecanica de Jogo não terminar o Jogo as ações serão apresentadas no console
        while (!mecanicaDoJogo.acabouJogo()){
            // Pega com a Mecânica do Jogo a Palavra da Vez
            String palavra = mecanicaDoJogo.palavraDaVez();

            // Cria a Palavra Embaralhada Através do Embaralhador
            String embaralhada = embaralhador.embaralhar(palavra);

            // mostra ao usuário a palavra no console
            System.out.println("Decifre a Palavra: " + embaralhada);

            // pega a resposta do usuario
            String resposta = in.nextLine();

            // envia a resposta para mecânica do jogo
            String resultado = mecanicaDoJogo.respostaDaVez(palavra, resposta);

            // pergunta se acertou para rodar as regras do jogo
            mecanicaDoJogo.acertouResposta();

            // de acordo com as regras verifica se passou de fase
            String passouDeFase = mecanicaDoJogo.passouDeFase();

            // Imprime o resultados solicitados
            System.out.println(passouDeFase);
            System.out.println(resultado);

        }
        // imprime o resultado quando o jogo finaliza
        System.out.println(mecanicaDoJogo.resultadoFinal());
    }
}
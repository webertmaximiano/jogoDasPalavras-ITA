# jogoDasPalavras-ITA
Trabalho Final do Curso de Orientação a Objetos do ITA
Especificação de Requisitos 

Jogo Das Palavras






Autor: Webert Maximiano














MARICÁ - RJ















O que a gente vai fazer? 
É o jogo das palavras embaralhadas.
Solicitação do Professor?

Então o objetivo do exercício é criar jogo onde partes de sua execução possam ser trocadas. O jogo é simples: apresentado ao jogador uma palavra com letras embaralhadas e o jogador deve tentar adivinhar a palavra correta.

O jogo será jogado no próprio console e a lista de palavras utilizadas pode ser fixa (pelo menos 20 palavras), tá? E eu gostaria muito que vocês tentassem fazer com que essas palavras fossem lidas de arquivo.

Você pode fazer o jogo no próprio console, existe aí a classe Scanner, que lê a entrada do usuário e ela tem que ser, ela é criada, você pega o System.in, que é a entrada do usuário

A classe principal, que é a aquela classe com método main, uma coisa importante é que, essa classe principal, é a única que pode ler as entradas do usuário do console, nenhuma outra pode fazer isso.

O BancoDePalavras, que é uma classe que possui o método que vai estar retornando uma palavra que é retornada aleatoriamente ali de uma lista de palavras, vinda a partir de arquivo, 

 Eu tenho uma interface, Embaralhador, que representa ali as classes responsáveis por embaralhar uma palavra, ou seja, ela recebe uma palavra e retorna a palavra embaralhada e eu quero que essa interface tenha pelo menos duas implementações, ta? Eu tenho uma fábrica de embaralhadores, que tem método que vai retornar aleatoriamente, embaralhador, ta? Então o que é que vai acontecer? Eu vou ter vários embaralhadores, certo? E aí eu vou chegar para a fábrica de embaralhadores e vou falar assim: olha, me dá dos seus embaralhadores, aí vai te retornar, você não sabe qual que é e você vai chamar o método para embaralhar a palavra…

vamos lá, vai ter uma interface chamada MecanicaDoJogo, ta? Essa interface que vai dar o andamento para o jogo. Então por exemplo, ela que vai dizer se o jogo já acabou, vai dizer se o usuário acertou ou não a palavra, se ele pode tentar novamente, quantos pontos ele ganha. E eu também quero por exemplo duas implementações dessa interface. 

Então, tudo isso vai depender dessa classe MecanicaDoJogo, ta? Então, aí tem a fabrica da mecânica do jogo que vai retornar a mecânica do jogo que você vai querer utilizar naquela partida. Pode ser aleatório, ou você pode setar individualmente, mas a ideia é que seja fácil de mudar a mecânica do jogo, sem você ter que mexer no método principal, simplesmente trocando a instância de mecânica.

 a classe principal tem que recuperar a instância de MecanicaDoJogo de FabricaMecanica, a partir dessa classe fábrica de mecânica do jogo e a classe principal não pode ter nenhuma referência a uma implementação específica da MecanicaDoJogo, ta? Somente a interface dela.

Da mesma forma as implementações de MecanicaDoJogo devem recuperar os embaralhadores da fabrica de embaralhadores também não pode ter nenhuma referência direta a uma implementação específica do embaralhador, somente a interface

E as implementações de embaralhador tem que ter algoritmos de embaralhamentos de palavras, como sei lá, inverter a string, permutar randomicamente algumas letras, trocar letras pares por letras ímpares e aí fica a cargo da criatividade de cada inventar aí embaralhador, ta?

As implementações da MecanicaDoJogo devem retratar o andamento do jogo. Dei aí alguns exemplos, mas exemplos de questões que podem mudar nessa mecânica do jogo. Quando é que jogo termina por exemplo, após número fixo de palavras; após número de erros e etc, após fazer uma determinada quantidade de pontos.

 O que é importante é que, independente desse funcionamento, a classe principal tem que interagir com ela da mesma forma, ou seja, como é que a classe principal vai saber se terminou o jogo? Vai estar perguntando para a MecanicaDoJogo:! Já terminou? Se ainda não terminou me dá a próxima palavra. Alguma coisa desse tipo. E por exemplo, no final do jogo:! Como é que eu vou saber a pontuação? Também você vai perguntar lá para a MecanicaDoJogo, qual que é a pontuação que o usuário conseguiu fazer, certo?

 O que é que você tem que entregar para mim? O código que você criar de todas essas classes do jogo; diagrama de classe com classes que você criou; os testes de pelo menos das classes de embaralhamento, ta? Se você quiser criar testes para as outras classes, fique à vontade, recomendo, mas talvez precise de algumas técnicas que a gente não viu ainda, mas pelo menos as classes de embaralhamento, tenho certeza que vocês conseguem criar os testes e por fim eu quero que você faça, uma ou mais partidas do jogo mostrando ele funcionando e grave video para mim e disponibilize esse video de uma forma aberta, passando o link, sei lá, você pode compartilhar o arquivo, você pode colocar ele alguma plataforma aberta, como Youtube e outras que têm por aí, ta certo? Então é isso, espero que vocês tenham entendido. Boa sorte executar a tarefa e aplicar aí todos os conhecimentos que você adquiriu nesse primeiro módulo do curso.   
Como funciona?
 É jogo simples que você recebe uma palavra embaralhada, que as letras foram embaralhadas e você tem que adivinhar qual que é a palavra original.

Digitando a Resposta no Console




O que será feito?
Classe Principal
Classe Principal 

Classes para Embaralhar as Palavras
Interface Embaralhador 
1 Método embaralhar() 
1 Implementação Classe FabricaDeEmbaralhadores 
2 Implementação Classe EmbaralharAleatório
3 Implementação Classe EmbaralharInverso
4 Implementação Classe EmbaralharPrimeiroParDepoisImpar

Classes para Banco de Palavras
Classe BancoDePalavras
1 Arquivo TXT com 20 nomes, 1 por Linha

Classes para Mecânica do Jogo
Interface MecanicaDoJogo
1 Implementação Classe FabricaMecanica
2 Implementação Classe CincoChances
3 Implementação Classe DeDezAcaba
4 Implementação Classe ErrouAcabou


Classes para Testes Junit 
TesteEmbaralharPalavras
TesteFontePalavras
TesteJogo
TestePrincipal






Como foi feito?
Esse jogo foi feito em pedaços, de forma que cada pedaço desse jogo possa ser facilmente trocado.
Terá várias classes, cada uma será utilizada para determinadas tarefas.
As Palavras serão lidas de um arquivo TXT com 20 palavras, sendo 1 por linha..
Primeiro Passo - Banco de Palavras
Iniciamos criando a Classe BancoDePalavras - Ler um Arquivo TXT, possuir um método para retornar uma palavra aleatoriamente

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
   private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo
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

Na variável arquivo, coloquei o endereço do Arquivo TXT, que será o Banco de Palavras.

O Método getPalavraAleatoria() pega uma palavra no Banco e devolve de forma aleatória.
Criamos a Classe de Teste FontePalavras.

package Testes.FontePalavras;


import FontePalavras.BancoDePalavras;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.String;
import java.util.List;


public class TesteFontePalavras {


   private static BancoDePalavras banco;


   @BeforeAll
   public static void setup() {
       banco = new BancoDePalavras("F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"); // substitua pelo caminho do seu arquivo
   }
   @Test
   public void testGetPalavraAleatoria() {
       String palavra = banco.getPalavraAleatoria();
       System.out.println(palavra);
       List<String> palavras = banco.getPalavras();
       Assertions.assertTrue(palavras.contains(palavra)); // verifica se a palavra está na lista de palavras
   }
}





Segundo Passo - Embaralhar Palavras
Agora Vamos Criar as Classes responsáveis por Embaralhar as Palavras, Iniciamos pela Interface Embaralhador, que será acionada para fornecer a palavra embaralhada, através do método público embaralhar()

package EmbaralharPalavras;


public interface Embaralhador {
   String embaralhar(String palavra);


}


Foi solicitado duas implementações dessa interface, mas iremos realizar 4, assim nosso jogo ficará com mais opções de embaralhamento e com o nível mais avançado.
Primeira implementação - Classe EmbaralharAleatorio
package EmbaralharPalavras;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EmbaralharAleatório implements Embaralhador{
   @Override
   public String embaralhar(String palavra) {
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
}

Nessa Classe o método embaralhar() retorna uma palavra aleatória, ele usa classes padrão do Java e por isso precisa importa, linhas 3 a 5. As classes "ArrayList", "Collections" e "List".
Uma lista de caracteres é criada e cada caractere da palavra recebida por parâmetro pelo método é adicionado a essa lista.
A lista de caracteres é embaralhada utilizando o método "shuffle" da classe Collections.
Um objeto StringBuilder é criado para concatenar os caracteres da lista embaralhada e retornar uma String.
Segunda implementação - Classe EmbaralharInverso
Na implementação, é criado um objeto stringbuilder com a palavra original como argumento, e em seguida, é chamado o método reverse desse objeto, que inverte a ordem dos caracteres da palavra. Por fim, é chamado o método tostring para converter o resultado de volta em uma string e retorná-lo.

package EmbaralharPalavras;


public class EmbaralharInverso implements Embaralhador{


   @Override
   public String embaralhar(String palavra) {
       return new StringBuilder(palavra).reverse().toString();
   }


}
Terceira implementação - Classe EmbaralharPrimeiroParDepoisImpar

package EmbaralharPalavras;


import java.util.ArrayList;
import java.util.List;


public class EmbaralharPrimeiroParDepoisImpar implements Embaralhador{
   @Override
   public String embaralhar(String palavra) {
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

Nessa Classe o embaralhamento consiste em separar os caracteres da palavra em duas listas diferentes, uma para os índices pares e outra para os índices ímpares. Em seguida, os caracteres pares são adicionados primeiro ao stringbuilder, seguidos pelos caracteres ímpares. Por fim, o stringbuilder é convertido em uma string e é retornado como resultado do embaralhamento.
Quarta implementação - Classe FabricaDeEmbaralhador
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

Nessa Classe a implementação da interface Embaralhador, através do método embaralhar(), 
usa o método embaralhador é onde a lógica de embaralhamento é implementada. Ele usa um objeto da classe Random para escolher aleatoriamente um dos três métodos de embaralhamento disponíveis e então retorna a palavra embaralhada por aquele método.

Criamos a Classe de Teste EmbaralharPalavras
Como orientado sempre que criarmos uma classe devemos criar o teste de suas funções e métodos. 

package Testes.EmaralharPalavras;


import EmbaralharPalavras.EmbaralharAleatório;
import EmbaralharPalavras.EmbaralharInverso;
import EmbaralharPalavras.EmbaralharPrimeiroParDepoisImpar;
import EmbaralharPalavras.FabricaDeEmbaralhadores;
import org.junit.jupiter.api.Test;


import java.util.Random;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TesteEmbaralharPalavras {
       // Antes de realizar o Teste carrega o Setup
       Random random;
       FabricaDeEmbaralhadores fabricaDeEmbaralhadores = new FabricaDeEmbaralhadores();
       EmbaralharInverso embaralharInverso = new EmbaralharInverso();
       EmbaralharAleatório embaralharAleatório = new EmbaralharAleatório();
       EmbaralharPrimeiroParDepoisImpar embaralharParesDepoisImpares = new EmbaralharPrimeiroParDepoisImpar();


       String palavra = "exemplo";


   @Test // testando o metodo embaralhar() da FabricaDeEmbaralhadores
   public void testeEmbaralhar() {


       String embaralhada = fabricaDeEmbaralhadores.embaralhar(palavra);
       System.out.println(embaralhada);
       //palavra precisa vim embaralhada não pode ser igual.
       assertNotEquals(palavra, embaralhada);
   }


   @Test // testando o metodo embaralhardor() da FabricaDeEmbaralhadores
   public void testeEmbaralhador() {
       String embaralhada = fabricaDeEmbaralhadores.embaralhador(palavra);
       System.out.println(embaralhada);
       //palavra precisa vim embaralhada não pode ser igual.
       assertNotEquals(palavra, embaralhada);


   }


   @Test // testando o EmbaralharInverso
   public void testeEmbaralhadorInverso(){
       String embaralhada = embaralharInverso.embaralhar(palavra);
       System.out.println(embaralhada);
       //palavra precisa vim embaralhada invertida.
       assertEquals("olpmexe", embaralhada);
   }


   @Test //testando EmbaralharPrimeiroParDepoisImpar
   public void testeEmbaralharParesDepoisImpares() {
       String embaralhada = embaralharParesDepoisImpares.embaralhar(palavra);
       System.out.println(embaralhada);
       // cada letra recebe um indice 0e 1x  2e 3m 4p 5l 6o, pares+impares 0246135
       assertEquals("eepoxml", embaralhada);
   }


}


Terceiro Passo - Classes da Mecânica de Jogo
Iniciamos com a criação da Interface MecanicaDoJogo, ela é responsável pelo andamento do Jogo, foi solicitado 2 implementações, mas realizamos 3. 

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

A Primeira Implementação - Classe ErrouAcabou

package Jogo;


import FontePalavras.BancoDePalavras;


public class ErrouAcabou implements MecanicaDoJogo{


   private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo
   private boolean errou = false;
   private int pontos = 0;
   private String resultadoRespostaDavez;
   private int tentativas =0;
   private BancoDePalavras banco = new BancoDePalavras(arquivo);
   @Override
   public String modoDeJogo() {
       return "Errou Acabou!";
   }


   @Override
   public String instrucoes() {
       return "Digite a Palavra Certa e Ganhe Pontos, erre e o jogo acaba!";
   }


   @Override
   public Boolean acabouJogo() {
       return errou;
   }


   @Override
   public String palavraDaVez() {
       return banco.getPalavraAleatoria();
   }


   @Override
   public Boolean acertouResposta() {
       return true;
   }


   @Override
   public String respostaDaVez(String palavra, String resposta) {


       if (palavra.equals(resposta)){
           tentativas+=1;
           pontos+=2;
           return resultadoRespostaDavez = "Resposta Correta! Vamos pra Próxima!";
       }else {
           errou = true;
           return resultadoRespostaDavez = "Resposta Errada! Acabou o Jogo!";
       }


   }


   @Override
   public String passouDeFase() {
       if (resultadoRespostaDavez.equals("Resposta Correta! Vamos pra Próxima!") ){
           return "Você Passou de Fase!";
       } else {
           return "Você não Passou de Fase!";
       }
   }


   @Override
   public String resultadoFinal() {
       return "Você realizou "+tentativas+" Tentativas e Marcou "+pontos+" pontos";
   }
}

Essa Classe faz com que o Jogo funcione dando apenas uma oportunidade de resposta ao usuário, se ele acerta, então continua respondendo e marcando pontos, senão o jogo termina, consequentemente, informa o resultado final.

A Segunda Implementação - Classe CincoChances
Nessa Classe o jogo funciona de outra maneira, dá ao usuário 5 chances para ele decifrar a palavra, cada acerto vale 2 pontos, se nas 5 tentativas ele somar mais de 8 pontos, então ele passa de fase e continua a decifrar as palavras, caso contrário o jogo termina e exibe o resultado final.

package Jogo;


import FontePalavras.BancoDePalavras;


public class CincoChances implements MecanicaDoJogo {


   private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo


   private boolean gameover = false;
   private int pontos = 0;
   private int tentativas =0;
   private boolean passouDeFase= false;
   private String resultadoRespostaDavez;
   private BancoDePalavras banco = new BancoDePalavras(arquivo);
   @Override
   public String modoDeJogo() {
       return "Cinco Chances!";
   }
   @Override
   public String instrucoes() {
       return "Você tem 5 Chances! Passa de Fase se Somar mais de 8 Pontos";
   }


   @Override
   public Boolean acabouJogo() {
       return gameover;
   }


   @Override
   public String palavraDaVez() {
       return banco.getPalavraAleatoria();
   }


   @Override
   public Boolean acertouResposta() {


       if (tentativas == 5 && pontos > 8) {
           tentativas=0;
           pontos =0;
           passouDeFase = true;
           return gameover = false;
       } else {
           while (tentativas == 5 && pontos <8)
           return gameover = true;
       }
       return gameover;
   }


   @Override
   public String respostaDaVez(String palavra, String resposta) {


       if (palavra.equals(resposta) ){
           tentativas+=1;
           pontos+=2;
           return resultadoRespostaDavez = "Resposta Correta! Vamos pra Próxima!";
       }else {
           tentativas+=1;
           return resultadoRespostaDavez = "Resposta Errada! Tente Outra vez!";
       }


   }


   @Override
   public String passouDeFase() {
       if (passouDeFase) {
           return "Você Passou de Fase!";
       } else if (passouDeFase == false && gameover == true) {
           return "Você não Passou de Fase!";
       } else {
           return "Próxima tentativa.";
       }
   }


   @Override
   public String resultadoFinal() {
       return "Você realizou "+tentativas+" Tentativas e Marcou "+pontos+" pontos";
   }
}

A Terceira Implementação - Classe DeDezAcaba
Ela tem o seguinte funcionamento, vai fornecer palavras aleatória para ser decifradas, enquanto o usuário não atingir 10 pontos, ele ficará de castigo respondendo kkk, 

package Jogo;


import FontePalavras.BancoDePalavras;


public class DeDezAcaba implements MecanicaDoJogo{
   private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo


   private boolean terminou = false;
   private int pontos = 0;
   private int tentativas =0;
   private boolean passouDeFase;
   private BancoDePalavras banco = new BancoDePalavras(arquivo);


   @Override
   public String passouDeFase() {
       if (passouDeFase) {
           return "Você Conseguiu Somar 10 Pontos!";
       } else if (passouDeFase == false && terminou == true) {
           return "O Jogo Acabou!";
       } else {
           return "Próxima tentativa";
       }
   }


   @Override
   public String modoDeJogo() {
       return "De Dez Acaba!";
   }
   @Override
   public String instrucoes() {
       return "Você tem que Somar 10 Pontos, caso contrário vai ficar tentando! ";
   }


   @Override
   public Boolean acabouJogo() {
       return terminou;
   }


   @Override
   public String palavraDaVez() {
       return banco.getPalavraAleatoria();
   }


   @Override
   public Boolean acertouResposta() {
       if ( pontos >= 10) {
           passouDeFase = true;
           return terminou = true;
       } else {
           passouDeFase = false;
           return terminou = false;
       }
   }


   @Override
   public String respostaDaVez(String palavra, String resposta) {


       if (palavra.equals(resposta) ){
           tentativas+=1;
           pontos+=2;
           return  "Resposta Correta! Vamos pra Próxima!";
       }else {
           tentativas+=1;
           return  "Resposta Errada! Tente Outra vez!";
       }


   }


   @Override
   public String resultadoFinal() {
       return "Você realizou "+tentativas+" Tentativas e Marcou "+pontos+" pontos";
   }
}

Criamos a Classe FabricaMecanicaDeJogo
Através dela é possível iniciar uma Mecânica de Jogo de Forma fácil, além de ter um método que retorna uma forma aleatoriamente.

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

Criamos as Classes de Testes do Jogo 
Crie teste para cada Classe da Mecanica do Jogo

ErrouAcabou
package Jogo;


import FontePalavras.BancoDePalavras;


public class ErrouAcabou implements MecanicaDoJogo{


   private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo
   private boolean errou = false;
   private int pontos = 0;
   private String resultadoRespostaDavez;
   private int tentativas =0;
   private BancoDePalavras banco = new BancoDePalavras(arquivo);
   @Override
   public String modoDeJogo() {
       return "Errou Acabou!";
   }


   @Override
   public String instrucoes() {
       return "Digite a Palavra Certa e Ganhe Pontos, erre e o jogo acaba!";
   }


   @Override
   public Boolean acabouJogo() {
       return errou;
   }


   @Override
   public String palavraDaVez() {
       return banco.getPalavraAleatoria();
   }


   @Override
   public Boolean acertouResposta() {
       return true;
   }


   @Override
   public String respostaDaVez(String palavra, String resposta) {


       if (palavra.equals(resposta)){
           tentativas+=1;
           pontos+=2;
           return resultadoRespostaDavez = "Resposta Correta! Vamos pra Próxima!";
       }else {
           errou = true;
           return resultadoRespostaDavez = "Resposta Errada! Acabou o Jogo!";
       }


   }


   @Override
   public String passouDeFase() {
       if (resultadoRespostaDavez.equals("Resposta Correta! Vamos pra Próxima!") ){
           return "Você Passou de Fase!";
       } else {
           return "Você não Passou de Fase!";
       }
   }


   @Override
   public String resultadoFinal() {
       return "Você realizou "+tentativas+" Tentativas e Marcou "+pontos+" pontos";
   }
}

CincoChances
package Jogo;


import FontePalavras.BancoDePalavras;


public class CincoChances implements MecanicaDoJogo {


   private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo


   private boolean gameover = false;
   private int pontos = 0;
   private int tentativas =0;
   private boolean passouDeFase= false;
   private String resultadoRespostaDavez;
   private BancoDePalavras banco = new BancoDePalavras(arquivo);
   @Override
   public String modoDeJogo() {
       return "Cinco Chances!";
   }
   @Override
   public String instrucoes() {
       return "Você tem 5 Chances! Passa de Fase se Somar mais de 8 Pontos";
   }


   @Override
   public Boolean acabouJogo() {
       return gameover;
   }


   @Override
   public String palavraDaVez() {
       return banco.getPalavraAleatoria();
   }


   @Override
   public Boolean acertouResposta() {


       if (tentativas == 5 && pontos > 8) {
           tentativas=0;
           pontos =0;
           passouDeFase = true;
           return gameover = false;
       } else {
           while (tentativas == 5 && pontos <8)
           return gameover = true;
       }
       return gameover;
   }


   @Override
   public String respostaDaVez(String palavra, String resposta) {


       if (palavra.equals(resposta) ){
           tentativas+=1;
           pontos+=2;
           return resultadoRespostaDavez = "Resposta Correta! Vamos pra Próxima!";
       }else {
           tentativas+=1;
           return resultadoRespostaDavez = "Resposta Errada! Tente Outra vez!";
       }


   }


   @Override
   public String passouDeFase() {
       if (passouDeFase) {
           return "Você Passou de Fase!";
       } else if (passouDeFase == false && gameover == true) {
           return "Você não Passou de Fase!";
       } else {
           return "Próxima tentativa.";
       }
   }


   @Override
   public String resultadoFinal() {
       return "Você realizou "+tentativas+" Tentativas e Marcou "+pontos+" pontos";
   }
}

DeDezAcaba
package Jogo;


import FontePalavras.BancoDePalavras;


public class DeDezAcaba implements MecanicaDoJogo{
   private String arquivo = "F:\\www\\curso\\ita-java\\TrabalhoFinal\\JogoDasPalavras\\src\\FontePalavras\\palavras.txt"; // substitua pelo caminho do seu arquivo


   private boolean terminou = false;
   private int pontos = 0;
   private int tentativas =0;
   private boolean passouDeFase;
   private BancoDePalavras banco = new BancoDePalavras(arquivo);


   @Override
   public String passouDeFase() {
       if (passouDeFase) {
           return "Você Conseguiu Somar 10 Pontos!";
       } else if (passouDeFase == false && terminou == true) {
           return "O Jogo Acabou!";
       } else {
           return "Próxima tentativa";
       }
   }


   @Override
   public String modoDeJogo() {
       return "De Dez Acaba!";
   }
   @Override
   public String instrucoes() {
       return "Você tem que Somar 10 Pontos, caso contrário vai ficar tentando! ";
   }


   @Override
   public Boolean acabouJogo() {
       return terminou;
   }


   @Override
   public String palavraDaVez() {
       return banco.getPalavraAleatoria();
   }


   @Override
   public Boolean acertouResposta() {
       if ( pontos >= 10) {
           passouDeFase = true;
           return terminou = true;
       } else {
           passouDeFase = false;
           return terminou = false;
       }
   }


   @Override
   public String respostaDaVez(String palavra, String resposta) {


       if (palavra.equals(resposta) ){
           tentativas+=1;
           pontos+=2;
           return  "Resposta Correta! Vamos pra Próxima!";
       }else {
           tentativas+=1;
           return  "Resposta Errada! Tente Outra vez!";
       }


   }


   @Override
   public String resultadoFinal() {
       return "Você realizou "+tentativas+" Tentativas e Marcou "+pontos+" pontos";
   }
}

Quarto Passo - a Classes Principal do Jogo
A Classe Principal é onde unimos todos os pedaços do nosso jogo, além de interagir com o usuário através do Console.

Comentei toda classe para facilitar o entendimento do seu funcionamento e mostrando que cumprimos com as solicitações do Professor.

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




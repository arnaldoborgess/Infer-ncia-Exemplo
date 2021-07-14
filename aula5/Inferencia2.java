package aula5;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Inferencia2 {

    public static void main(String[] args) {
        testar("João", "Santos");
        try {
            connectAndPrintURLJavaOracle();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printSoma(5, 5, 5);
    }

    private static void connectAndPrintURLJavaOracle() throws IOException {
        var url = new URL("https://docs.oracle.com/javase/10/language/"); //requisições da java.net
        var urlConnection = url.openConnection();
        //fazendo um get do indpoint para pegar o conteúdo da página. open connetion ele abre uma conexão com a url

        try (var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*Bufferreader ele separa em linhas melhorando a leitura, getInputStream ele vai pegar todo fluxo de dados e
        vai colocar dentro do inputStream ImputStreamReader da opção para escolher se quer
        trabalhar com input Stream ou Reader */

        // System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
        //collect(.joining()) vai pegar as linhas e concatenar transformando em uma única string
        //replaceAll quebrou a linha toda vez que encontra o símbolo >
    }

    public static void testar(String nome, String sobrenome) {
        var nomeCompleto = String.format("%s %s", nome, sobrenome);
        System.out.println(nomeCompleto);
    }

    public static void printSoma(int... numeros) {
        int soma; //var aqui não pode ser utilizada
        if (numeros.length > 0) {
            soma = 0;
            for (var numero : numeros) {
                soma += numero;
            }
            //dentro do for é possível usar a inferência do tipo variável
            System.out.println("A soma é ::: " + soma);
        }

    }
}

    /*

A inferência começou a partir do Java 10!
Inferência é a capacidade de estar abinstraindo os tipos das variáveis a partir da instancia, assim conseguir saber
qual a variável que está trabalhando.
O tipo será substituido pela palavra reservada "var" quando já se sabe qual é a instância, não em todos os casos pois
pode haver erro de compilação. A palavra reservada var é somente utilizada para variáveis locais.
Ela nos dá menos verbocidade para as declarações no código.

public void testar(var nome) {
        System.out.println(nome);
    }
 O var não pode ser utilizado a nível de classe também não pode ser utilizado como parâmetro.

Var Consegue

   variáveis locais inicializadas
   variável suporte do enhaced for
   variável suporte do for interativo
   varaável try with resource

   Var Não consegue

   Em nível de classe
   Como parâmetro
   Em variáveis locais não inicializadas

  */

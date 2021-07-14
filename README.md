# Infer-ncia-Exemplo
Estudo de Inferência de variáveis ☕ Java!


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

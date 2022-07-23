<h1>Calculadora-POO</h1> 

<p align="center">
  <img src="http://img.shields.io/static/v1?label=Java&message=1.8.0_291&color=orange&style=for-the-badge&logo=java"/>
  <img src="http://img.shields.io/static/v1?label=ANSI&message=A%20little%20bitter&color=blue&style=for-the-badge&logo=ANSI"/>
  <img src="http://img.shields.io/static/v1?label=TESTES&message=%3E100&color=GREEN&style=for-the-badge"/>
  <img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
  <img src="http://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge"/>
</p>

<a href="https://hits.seeyoufarm.com"><img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Ftgzx%2FCalculadora-POO&count_bg=%232B1A82&title_bg=%235C66AE&icon=github.svg&icon_color=%23E1E1E1&title=Views&edge_flat=false"/></a>

> Status do Projeto: :heavy_check_mark: (Concluído)

### Tópicos 

:small_blue_diamond: [Descrição do projeto](#descrição-do-projeto)

:small_blue_diamond: [Funcionalidades](#funcionalidades)

:small_blue_diamond: [Imagens](#imagens)

:small_blue_diamond: [Código](#código)

:small_blue_diamond: [Como rodar a aplicação](#como-rodar-a-aplicação-arrow_forward)


## Descrição do projeto 

<p align="justify">
  Programa de calculadora utilizando conhecimentos de POO em Java. No console só precisa digitar os dois numeros que se deseja fazer a operação e o seu operador, sem espaços e sem saltar linhas. Exemplos de sintaxe: 
</p>

~~~java
1+1
~~~
ou
~~~java
25*300
~~~

## Funcionalidades
<p align="justify">
  Nada novo, apenas a boa e velha calculadora, a grande "novidade" aqui é a forma como código foi estruturado para executar as funções de somar, subtrair, dividir e multiplicar.
</p>

## Imagens

> Sem prints por enquanto.

## Código
> Os códigos podem estar ligeiramente diferentes do que os apresentados aqui.
<p align="justify">
  As classes do pacote "Procedimentos" (Adição, Subtração, etc) implementam a interface "Operacao" fazendo com que o código fique mais limpo e menos bagunçado.
  </p>
  
~~~java
public interface Operacao {
    public abstract int calculo(int num, int num2);
}
~~~

<p align="justify">
  As classes que implementam "Operacao" têm o mesmo padrão, eles retornam uma operação de acordo com o operador que foi capurado na classe "Operandos" no pacote "Comparadores". Alguns exemplos:
  </p>
  
~~~java
package Procedimentos;

public class Adicao implements Operacao{

    @Override
    public int calculo(int num, int num2) {
        return num + num2;
    }
}
~~~

~~~java
package Procedimentos;

public class Multiplicacao implements Operacao{

    @Override
    public int calculo(int num, int num2) {
        return num * num2;
    }
}
~~~

<p align="justify">
  Classe "Operandos" engloba os operadores que implementei no meu código. Essa classe verifica qual o operador foi informado na String "res" lá no main.
  </p>
  
~~~java
package Comparadores;

import Procedimentos.*;

public class Operandos {
    public static Operacao converter(char operando) {
        if (operando == '+'){
            return new Adicao();
        } else if (operando == '-'){
            return new Subtracao();
        } else if (operando == '/'){
            return new Divisao();
        } else if (operando == '*'){
            return new Multiplicacao();
        } else if (operando == '%'){
            return new Modulo();
        } else {
            return new Erro();
        }
    }
}
~~~

<p align="justify">
  Por último, mas altamente importante, eu fiz um checker que valida a entrada do valor que é, pasmem, STRING. Para que fosse possível fazer um cálculo sem dar espaços ou saltar linhas para atribuir valores às variáveis, era necessário receber uma String, e o checker abaixo, que não respeita nenhuma das boas práticas em programação (me perdoem por isso), checa cada caractere dessa String usando um array de char dessa mesma string, ela verifica até onde vai o primeiro número, daí salva numa variável esse primeiro número encontrado e com a informação da variável "cont" ela salva o próximo caratere em "op", que vai ser o nosso operador, e por último ele pega os carecteres depois de "cont", ou seja, depois do "op" que é o nosso operador, e guarda numa terceira variável, e retorna tudo pro Main e printa na tela. 
  
  É confuso eu sei, eu tentei deixar mais simples, mas foi o que eu consegui fazer :D. Vou aprimorar meus conhecimentos logo mais. Abaixo, mostro o código, que é o resultado da batida de dois Fiat Uno:
  </p>
  
~~~java
package Comparadores;

public class CheckRes {
    public Object[] comparador(String res) {
        Object[] resFinal = new Object[3];
        char[] resChar = res.toCharArray();
        int cont = 0;
        int cont2= 0;

        for (int i = 0; i < resChar.length && "1234567890".contains(""+resChar[i]); i++) {
            cont++;
            cont2 = cont;
        }

        //----- Pega o PRIMEIRO numero -----//
        char[] numCompleto = new char[cont];
        for (int i = 0; i < cont; i++) {
            numCompleto[i] = resChar[i];
        }
        String numString1 = new String(numCompleto);
        resFinal[0] = Integer.parseInt(numString1);

        //----- Pega o SEGUNDO numero -----//
        int positiveArray = resChar.length - (cont + 1);
        char[] numCompleto2 = new char[positiveArray];
        cont2 = cont2 + 1;
        for (int i = 0; i < numCompleto2.length; i++) {
            numCompleto2[i] = resChar[cont2 + i];
        }
        String numString2 = new String(numCompleto2);
        resFinal[2] = Integer.parseInt(numString2);
        resFinal[2] = ((int)resFinal[2] < 0 ? -(int)resFinal[2] : (int)resFinal[2]);

        //----- Pega o OPERADOR -----//
        resFinal[1] = resChar[cont];

        //----- Testa os Valores -----//
        //System.out.println(resFinal[0]);
        //System.out.println(resFinal[1]);
        //System.out.println(resFinal[2]);
        return resFinal;
    }

    public static void checkResValues(String res){
        if (!res.equals("")){
            char[] resChar = res.toCharArray();
            for (int i = 0; i < res.length(); i++) {
                if (!"1234567890+/*-%".contains(""+resChar[i])){
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
~~~
  
## Como rodar a aplicação :arrow_forward:

No terminal, clone o projeto: 

~~~
git clone https://github.com/tgzx/Calculadora-POO.git
~~~

Você pode rodar direto no CMD ou em uma IDE.

## Desenvolvedores/Contribuintes :octocat:

| [<img src="https://avatars.githubusercontent.com/u/82123497?v=4" width=100><br><sub>Tiago Moreira<br>(Desenvolvedor)</sub>](https://github.com/tgzx) | [<img src="https://avatars.githubusercontent.com/u/11353496?v=4" width=100><br><sub>Rodrigo Santiago<br>(Contribuinte)</sub>](https://github.com/RodrigoSantiago) |
| :---: | :---: 

## Licença 

The [MIT License]() (MIT)

Copyright :copyright: 2022 - Calculadora-POO

package Taurus;

import java.util.Scanner;


public class Uno {
    public static void main(String[] args) {
    String phrase = ""; int index = 0;
    Scanner yuu = new Scanner (System.in);
    System.out.print("Bem vinda(o), por favor, digite uma frase: ");
    try {
        phrase = yuu.nextLine();
        index = phrase.length();
    } catch (Error | Exception e) {
        System.out.print("Oops, erro \"" + e + "detectado!");
    }
    vog(phrase, index);
    con(phrase, index);
    pvs(phrase, index);
    npa(phrase, index);

    }

    public static void vog (String phrase, int index){
        char veri; double sheep = 0, len = index; String letter;
        while (index > 0){ //Enquanto tamanho da página for maior que '0'
            index--;
            veri = phrase.charAt(index); //verifique o caractere 'index' da palavra
            letter = String.valueOf(veri);
            if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i")
                    || letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")) { //e conte cada instância de vogal.
                sheep ++;
            }
        }
        System.out.print("Vogais \nNúmero:" + sheep + ".\nPercentual:" + (sheep/len)*100 + "%.\n\n");
    }

    public static void con (String phrase, int index){
        char veri; double sheep = 0, len = index; String letter;
        while (index > 0){
            index--;
            veri = phrase.charAt(index);
            letter = String.valueOf(veri);
            if (!letter.equalsIgnoreCase("a") || !letter.equalsIgnoreCase("e") || !letter.equalsIgnoreCase("i")
                    || !letter.equalsIgnoreCase("o") || !letter.equalsIgnoreCase("u")) //Se difetente de consoantes, incremento.
                sheep ++;
        }
        System.out.print("Consoantes \nNúmero:" + sheep + ".\nPercentual:" + (sheep/len)*100 + "%.\n\n");
    }

    public static void pvs (String phrase, int index){
        String letter; char veri; int len = index; double [] individual = {0,0,0,0,0}; String [] letras = {"A", "E", "I", "O", "U"};
        while (index > 0){
            index--;
            veri = phrase.charAt(index);  //Caractere se torna letra na posição "index"
            letter = String.valueOf(veri); //Letra é adicionada para comparação de ambas consoantes, maiúscula ou minúscula
            if (letter.equalsIgnoreCase("a")) //Se for igual
                individual[0] ++;
            if (letter.equalsIgnoreCase("e"))
                individual[1] ++;
            if (letter.equalsIgnoreCase("i"))
                individual[2] ++;
            if (letter.equalsIgnoreCase("o"))
                individual[3] ++;
            if (letter.equalsIgnoreCase("u"))
                individual[4] ++;
        }
        for (index = 0; index < 5; index++){
            System.out.print(letras[index] + ": " + (individual[index]/len)*100 + "%.\n\n");
        }
    }

    public static void npa (String phrase, int index) {
        char veri, veri2; int sheep = 0;
        index --;
        if (phrase.length() != 0) //Contador iniciado em 1 para contabilizar primeira palavra
            sheep = 1;
        while (index > 1){ //Usado para garantir que todas as posições serão atingidas com veri e veri2
            index--;
            veri = phrase.charAt(index - 1);
            veri2 = phrase.charAt(index);
            if (veri != 32 && veri2 == 32) //Se a palavra possuir um caractere diferente de espaço a frente de um espaço
                sheep++;
        }
        System.out.print(sheep + " palavras contabilizadas.");
    }
}

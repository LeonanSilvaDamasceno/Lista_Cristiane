package Taurus;

import java.util.Scanner;


public class Uno {
    public static void main(String[] args) {
    String phrase; int index;
    Scanner yuu = new Scanner (System.in);
    System.out.print("Bem vinda(o), por favor, digite uma frase: ");
    phrase = yuu.nextLine();
    index = phrase.length();

    vog(phrase, index);
    con(phrase, index);
    pvs(phrase, index);
    npa(phrase, index);

    }

    public static void vog (String phrase, int index){
        char veri; double sheep = 0, len = index; String letter;
        while (index >0){
            index--;
            veri = phrase.charAt(index);
            letter = String.valueOf(veri);
            if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i")
                    || letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")) {
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
            if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || letter.equalsIgnoreCase("i")
                    || letter.equalsIgnoreCase("o") || letter.equalsIgnoreCase("u")){}
            else {
                sheep ++;
            }
        }
        System.out.print("Consoantes \nNúmero:" + sheep + ".\nPercentual:" + (sheep/len)*100 + "%.\n\n");
    }

    public static void pvs (String phrase, int index){
        String letter; char veri; int len = index; double [] individual = {0,0,0,0,0}; String [] letras = {"A", "E", "I", "O", "U"};
        while (index > 0){
            index--;
            veri = phrase.charAt(index);
            letter = String.valueOf(veri);
            if (letter.equalsIgnoreCase("a"))
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

    public static void npa (String phrase, int index){
        char veri; int sheep = 1;
        while (index > 0){
            index--;
            veri = phrase.charAt(index);
            if (veri == 32){
                sheep++;
            }
        }
        System.out.print(sheep + " palavras contabilizadas.");
    }

}

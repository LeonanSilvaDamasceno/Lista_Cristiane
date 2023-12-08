package Taurus;

import java.util.Scanner;

public class Catorce {
    public static void main (String [] args){
        Scanner yuu = new Scanner(System.in);
        int index, aux;
        try {
            System.out.print("Digite o número de posições do vetor: ");
            index = yuu.nextInt();
            Double[] v = new Double[index];
            for (aux = 0; aux < index; aux++) {
                System.out.print("Digite o " + (aux + 1) + "° valor: ");
                v[aux] = yuu.nextDouble();
            }
            if (index == 0) //Se houver apenas um número ele será o menor
                System.out.print(v[0]);
            else
                System.out.print(soma_n(v, index - 1, v[0]));
        }catch (Error | Exception e) {
            System.out.print("ERRO, tente com valores válidos!");
        }
    }

    public static double soma_n(Double[] v, int aux, Double aux_2) {
        return aux == 0? aux_2:soma_n(v, aux - 1, aux_2 + v[aux]);
    } //'aux.' diferente de início do array? Incremente aux_2 até somar todos os números :D
}

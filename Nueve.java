package Taurus;

import java.util.Scanner;

public class Nueve {
    public static void main (String [] args) {
        Scanner yuu = new Scanner(System.in);
        double n = 0, exp = 0, aux;
        try {
            System.out.println("Digite um número para a operação de potenciação: ");
            n = yuu.nextDouble();
            System.out.println("Digite o valor do expoente: ");
            exp = yuu.nextDouble();
        } catch (Error | Exception e) {
            System.out.print("Digite valores válidos!");
        }
        if (exp == 0) {
            System.out.print("Resultado: \"1\".");
        }
        else {
            aux = n;
            System.out.print(pot(n, exp, aux));
        }
    }

    public static double pot (double n, double exp, double aux){
        return exp == 1? n : pot(n*aux, exp-1, aux);
    } //Cálculo usando operador ternário. 'Aux.' é importante para a manutenção da potencialização com o valor inicial 'n' fixo.
}

package Taurus;

import java.util.Scanner;

public class Seis {
    public static void main (String [] args){
        Scanner yuu = new Scanner (System.in);
        int n = 0;
        try {
            System.out.println("Digite um valor para a aplicação da sequência de Collatz: ");
            n = yuu.nextInt();
        } catch (Error | Exception e) {
            System.out.print("Digite um valor válido!");
        }
        iterativa(n);
        System.out.print("Resultado final da operação recursiva:" + recursiva(n));
    }

    public static void iterativa (int n){
        while (n != 1){
           if (n % 2 == 0){
               n /= 2;
           } else {
               n = (n*3) + 1;
           }
           System.out.println(n);
        }
        System.out.println("Operação concluída!");
    }

    public static int recursiva (int n){
        return n != 1? n%2 == 0? recursiva(n/2) : recursiva(n*3 + 1): n;
    }
}
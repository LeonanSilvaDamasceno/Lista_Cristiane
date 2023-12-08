package Taurus;

import java.util.Scanner;

public class Dez {
    public static void main (String [] args){
        Scanner yuu = new Scanner(System.in);
        int n = 0, n2 = 0;
        try {
            System.out.println("Digite o primeiro número para o cálculo de MMC: ");
            n = yuu.nextInt();
            System.out.println("Digite o segundo valor: ");
            n2 = yuu.nextInt();
        } catch (Error | Exception e) {
            System.out.print("Digite valores válidos!");
        }
        System.out.print(mdc (n, n2));
    }

    public static int mdc (int n, int n2) {
        return n2 == 0? n : mdc(n2, n % n2);
    }
}

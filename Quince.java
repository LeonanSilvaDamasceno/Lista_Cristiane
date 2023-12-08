package Taurus;

import java.util.Scanner;

public class Quince {
    public static void main (String [] args){
        Scanner yuu = new Scanner (System.in);
        int n;
        System.out.print("Digite o número de discos: ");
        n = yuu.nextInt();
        torre_Hanoi(n, 'A','C' ,'B');
    }
    static void torre_Hanoi(int n, char da, char para, char auxiliar){
        if (n == 1) {
            System.out.println("Mova disco '1' do haste " + da + " para o haste " + para);
            return;
        }
        torre_Hanoi(n - 1, da, auxiliar, para);
        System.out.println("Mova o disco \"" + n + "\" do haste " + da + " para o haste " + para);
        torre_Hanoi(n-1, auxiliar, para, da);
    }  //Opções relativas as 'hastes'
}
import java.util.Scanner;

public class Questao_15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int n;
            System.out.print("Digite o número de discos: ");
            n = scanner.nextInt();
            System.out.println();

            // Calcula e exibe a quantidade mínima de passos necessários
            int passosTotais = passos(n);
            System.out.println("Serão necessários " + passosTotais + " passos no mínimo para completar essa Torre de Hanoi\n");
            System.out.println("==============================================");

            // Chama a função para resolver a Torre de Hanoi
            torre_Hanoi(n, 'A', 'C', 'B');
        } catch (java.util.InputMismatchException e) {
            System.err.println("Entrada inválida. Por favor, insira um número inteiro.");
        }
    }

    // Função recursiva para resolver a Torre de Hanoi
    static void torre_Hanoi(int n, char da, char para, char auxiliar) {
        if (n == 1) {
            System.out.println("Mova disco '1' do haste " + da + " para o haste " + para + "\n");
            return;
        }
        torre_Hanoi(n - 1, da, auxiliar, para);
        System.out.println("Mova o disco \"" + n + "\" do haste " + da + " para o haste " + para + "\n");
        torre_Hanoi(n - 1, auxiliar, para, da);
    }

    // Método para calcular a quantidade de passos que serão necessários de acordo com a quantidade de discos informados
    static int passos(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 2 * passos(n - 1) + 1;
        }
    }
}

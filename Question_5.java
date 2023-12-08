import java.util.*;

public class Questão_5 {

    public static void main(String[] args) {

        Scanner text = new Scanner(System.in);

        System.out.println("Digite o tempo do miojo, tempo da primeira ampulheta e tempo da segunda ampulheta (separados por espaços):");
        String[] entrada = text.nextLine().split(" ");

        if (entrada.length < 3) {
            System.out.println("Entrada inválida.Forneça três valores separados por espaços.");
            return;
        }

        int tempoMiojo = Integer.parseInt(entrada[0]);
        int ampulheta1 = Integer.parseInt(entrada[1]);
        int ampulheta2 = Integer.parseInt(entrada[2]);

           int tempoTotal = calcularTempoTotal(tempoMiojo, ampulheta1, ampulheta2);
        
        // Saída do tempo mínimo para o preparo do miojo
        System.out.println(tempoTotal);
    }

 // Função para calcular o tempo mínimo para o preparo do miojo
    private static int calcularTempoTotal(int tempoMiojo, int ampulheta1, int ampulheta2) {
        // Calcula o Mínimo Múltiplo Comum (MMC) entre os tempos das ampulhetas
        int mmc = calcularMMC(ampulheta1, ampulheta2);

        // Garante que o tempo total seja maior ou igual ao tempo do miojo
        while (mmc < tempoMiojo) {
            mmc += Math.max(ampulheta1, ampulheta2);
        }

        return mmc;
    }

    // Função para calcular o Mínimo Múltiplo Comum (MMC)
    private static int calcularMMC(int a, int b) {
        return (a * b) / calcularMDC(a, b);
    }

    // Função para calcular o Máximo Divisor Comum (MDC) usando o algoritmo de Euclides
    private static int calcularMDC(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

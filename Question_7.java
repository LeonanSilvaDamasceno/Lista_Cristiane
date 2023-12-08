import java.util.Scanner;

public class Questao_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite um número: ");
            int numero = scanner.nextInt();

            if (ehPrimo1(numero)) {
                System.out.println(numero + " é primo.");
            } else {
                System.out.println(numero + " não é primo.");
            }
        } catch (java.util.InputMismatchException e) {
            System.err.println("Entrada inválida. Por favor, insira um número inteiro.");
        }
    }

    // Função para verificar se um número é primo
    public static boolean ehPrimo1(int numero) {
        if (numero < 2) {
            return false; // Números menores que 2 não são primos
        }
        return ehPrimo2(numero, 2);
    }

    // Função recursiva para verificar se um número é primo
    private static boolean ehPrimo2(int numero, int divisor) {
        if (divisor > Math.sqrt(numero)) {
            return true; // Se nenhum divisor é encontrado até a raiz quadrada do número, é primo
        }
        return numero % divisor != 0 && ehPrimo2(numero, divisor + 1);
    }
}

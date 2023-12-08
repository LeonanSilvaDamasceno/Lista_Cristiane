import java.util.Scanner;

public class Questao_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe um número: ");
            int n = scanner.nextInt();

            System.out.println("A soma dos dígitos é: " + soma(n));
        } catch (java.util.InputMismatchException e) {
            System.err.println("Entrada inválida. Por favor, insira um número inteiro.");
        }
    }

    private static int soma(int n) {
        // Se o número fornecido for de somente um único dígito, vai ser retornado esse mesmo número
        if (n < 10) {
            return n;
        }

        return (n % 10) + soma(n / 10);
    }
}

import java.util.*;

public class Questão_13 {

    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);

        try {
            System.out.print("Digite uma palavra: ");
            String palavra = text.nextLine().toLowerCase();

            if (ehPalind(palavra)) {
                System.out.println("A palavra é um palíndromo.");
            } else {
                System.out.println("A palavra não é um palíndromo.");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida. Certifique-se de fornecer uma palavra válida.");
        } finally {
            text.close();
        }
    }

    // Função recursiva para verificar se uma palavra é um palíndromo
    public static boolean ehPalind(String string) {
        // Caso base: se a palavra tiver comprimento 0 ou 1, é um palíndromo
        if (string.length() <= 1) {
            return true;
        } else {
            // faz a comparação entre o primeiro e o ultimo.
            char primCarac = string.charAt(0);
            char ultCarac = string.charAt(string.length() - 1);

            // excluindo o primeiro e último caractere
            if (primCarac == ultCarac) {
                String palavraSemBordas = string.substring(1, string.length() - 1);
                return ehPalind(palavraSemBordas);
            } else {
               
                return false;
            }
        }
    }
}

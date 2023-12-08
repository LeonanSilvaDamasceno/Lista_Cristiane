import java.util.*;

public class Questão_11 {

    public static void main(String[] args) {
      Scanner text = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String string = text.nextLine();

        String invertido = invert(string);
        System.out.println("Texto Invertido: " + invertido);

        text.close();
    }

    // Função recursiva para inverter uma string
    public static String invert(String str) {
        // Caso base: se a string tiver comprimento 0 ou 1, ela já está invertida
        if (str.length() <= 1) {
            return str;
        } else {
            // Pegar o primeiro caractere
            char carac1 = str.charAt(0);
            // Inverter o resto.
            String restoInvertido = invert(str.substring(1));
          
            return restoInvertido + carac1;
        }
    }
}

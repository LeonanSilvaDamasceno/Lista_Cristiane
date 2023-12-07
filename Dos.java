package Taurus;

import java.util.Scanner;

public class Dos {
    public static void main (String [] args){
        Scanner yuu = new Scanner (System.in);
        int num_p;
        String txt, txt_cod = ""; String [] dic;
        System.out.println("Por favor, digite um texto: ");
        txt = yuu.nextLine();
        dic = dicionary(txt); //Criação de dicionário
        num_p = Integer.parseInt(dic[999]);
        txt_cod = coder(num_p,txt_cod); //Fornecimento de String codificada
        decoder(dic, num_p, txt, txt_cod);
    }

    public static String [] dicionary (String txt){
        int counter, index, fresh = 0; //Fresh resetará as posições 'index' do vetor para evitar a adição de "null", "nulo" nas posições do array em incremento.
        char ver_1, ver_2 = 0;
        String [] dic = new String[1000]; //Array do dicionário de palavras codificadas 'dic'
        try {
            for (counter = 0, index = 0; counter < txt.length(); counter++) {
                ver_1 = txt.charAt(counter);
                if (counter > 0) //Para evitar erros de limite, a variável de comparação na posição -1 só é implementada após a primeira contagem
                    ver_2 = txt.charAt(counter - 1); //Usado em 'if-else' para verificar o número de palavras em acordo com a presença de um espaço
                if (ver_1 != 32 && counter == 0) { //Novamente, uma exceção criada em vista da primeira contagem.
                    dic[index] = ""; //Usado com a finalidade de possibilitar o incremento de letras via 'char.At' retirando 'null' do começo de cada posição
                    dic[index] += ver_1; //Incremento de letra
                } else { //Se após segunda contagem
                    if (ver_1 != 32 && ver_2 == 32) { //Se condições de espaço forem alcançadas
                        index++; //Posição (e número de palavras) é incrimentada.
                        fresh = 42; //Restart do verificador enunciado previamente para remoção de 'null' no começo de cada posição
                    }
                    if (fresh == 42) {
                        dic[index] = "";
                        fresh = 3;
                    }
                    if (ver_1 != 32)
                        dic[index] += ver_1;
                }
            }
            dic[999] = String.valueOf(index); //Retorna a quantidade de palavras para a classe main para usos posteriores
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.print("-ERR0R- Texto muito grande!");
        }
        return dic;
    }

    public static String coder (int num_p, String txt_cod){
        while (num_p >= 0){
            txt_cod += num_p;
            num_p--;
        }
        return txt_cod;
    }

    public static void decoder (String [] dic, int num_p, String original, String codificada){ //Método criado para leitura do dicionário.
        String decoded = ""; int index;
        while (num_p >= 0) { //Enquanto menor que o número de palavras
            index = Integer.parseInt(String.valueOf(codificada.charAt(num_p))); //Pegue número na posição index do texto codificado
            decoded += dic[index] + " "; //E adicione a String 'decoded' da posição obtida no texto codificado
            num_p--;
        }
        System.out.print(decoded);
        if (decoded.equals(original + " ")) //Espaço adicionado para comparação considerando os espaços adicionados na decodificação
            System.out.print("Os textos são iguais!");
        else
            System.out.print("Os textos não são iguais!");
    }
}

import java.util.*;

public class Questão_4 {

       private static final int MAX_TCC = 100;
    private static String[] alunos = new String[MAX_TCC];
    private static String[] orientadores = new String[MAX_TCC];
    private static String[] titulos = new String[MAX_TCC];
    private static int[] status = new int[MAX_TCC];
    private static double[] notasOrient = new double[MAX_TCC];
    private static double[] notasAva1 = new double[MAX_TCC];
    private static double[] notasAva2 = new double[MAX_TCC];
    private static int contador = 0; // Contador de TCCs cadastrados

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loop principal do programa
        while (true) {
            // Exibição do menu
            System.out.println("=========================================");
            System.out.println("1. Cadastrar TCC");
            System.out.println("2. Inserir Defesa");
            System.out.println("3. Lista de TCCs em execução");
            System.out.println("4. Lista de TCCs aprovados e reprovados");
            System.out.println("5. Sair");
            System.out.print("Escolha a opção: ");

            // Leitura da opção do usuário
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                // Switch para lidar com as opções
                switch (opcao) {
                    case 1:
                        cadasTcc(scanner);
                        break;
                    case 2:
                        inserirDefesa(scanner);
                        break;
                    case 3:
                        listarTccExecucao();
                        break;
                    case 4:
                        listarTccAprov();
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (java.util.InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar o buffer de entrada
            }
        }
    }

    // Método para cadastrar um novo TCC
    private static void cadasTcc(Scanner scanner) {
        if (contador < MAX_TCC) {
            System.out.print("=======================\n");
            System.out.println("Cadastro de TCC:");

            // Leitura dos dados do TCC
            System.out.print("Nome do Aluno: ");
            alunos[contador] = scanner.nextLine();

            System.out.print("Nome do Orientador: ");
            orientadores[contador] = scanner.nextLine();

            System.out.print("Título do TCC: ");
            titulos[contador] = scanner.nextLine();

            status[contador] = 0; // Inicialmente em execução

            System.out.println("TCC cadastrado com sucesso!");
            contador++;
        } else {
            System.out.println("Limite de TCCs atingido!");
        }
    }

    // Método para inserir a defesa de um TCC
    private static void inserirDefesa(Scanner scanner) {
        System.out.println("Inserir Defesa: \n");
        System.out.println("Atenção! A defesa do TCC só pode ser feita de 0 a 10.");

        // Leitura do nome do aluno
        System.out.print("Nome do Aluno: ");
        String aluno = scanner.nextLine();

        // Encontrar o índice do TCC no array
        int indice = encontrarTccAluno(aluno);

        if (indice != -1) {
            try {
                // Leitura das notas da defesa
                System.out.print("Nota do Orientador: ");
                notasOrient[indice] = scanner.nextDouble();

                System.out.print("Nota do Avaliador 1: ");
                notasAva1[indice] = scanner.nextDouble();

                System.out.print("Nota do Avaliador 2: ");
                notasAva2[indice] = scanner.nextDouble();

                // Cálculo da média e determinação do status (aprovado ou reprovado)
                double media = calMedia(notasOrient[indice], notasAva1[indice], notasAva2[indice]);

                if (media >= 6.0) {
                    status[indice] = 1; // Aprovado
                } else {
                    status[indice] = 2; // Reprovado
                }

                System.out.println("Defesa registrada com sucesso!");
            } catch (java.util.InputMismatchException e) {
                System.err.println("Entrada inválida. Por favor, insira um número para as notas.");
                scanner.nextLine(); // Limpar o buffer de entrada
            }
        } else {
            System.out.println("TCC do aluno não encontrado.");
        }
    }

    // Método para listar TCCs em execução
    private static void listarTccExecucao() {
        System.out.println("===========================================\n");
        System.out.println("Lista de TCCs em Execução:");
        for (int i = 0; i < contador; i++) {
            if (status[i] == 0) {
                System.out.println("Aluno: " + alunos[i] + "\n"
                        + "Orientador responsável: " + orientadores[i] + "\n"
                        + "Título do Tcc: " + titulos[i] + "\n");
            }
        }
        System.out.println();
    }

    // Método para listar TCCs aprovados e reprovados
    private static void listarTccAprov() {
        System.out.println("=================================================");
        System.out.println("Lista de TCCs Aprovados e Reprovados:");
        for (int i = 0; i < contador; i++) {
            // Determina o resultado com base no status
            String resultado = (status[i] == 1) ? "Aprovado" : "Reprovado";

            // Exibe os dados do TCC
            System.out.println("Aluno: " + alunos[i] + ", Título: " + titulos[i]
                    + ", Nota Final: " + calMedia(notasOrient[i], notasAva1[i], notasAva2[i])
                    + ", Resultado: " + resultado);
        }
        System.out.println();
    }

    // Método para calcular a média das notas
    private static double calMedia(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // Método para encontrar o índice de um TCC no array usando o nome do aluno
    private static int encontrarTccAluno(String nomeAluno) {
        for (int i = 0; i < contador; i++) {
            if (alunos[i].equals(nomeAluno)) {
                return i;
            }
        }
        return -1;
    }
}

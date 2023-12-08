import java.util.*;

public static void main(String[] args) {
        try {
            // Configuração inicial
            int numValues = 100;
            int numClusters = 3;

            // Geração de valores aleatórios
            int[] values = generateRandomValues(numValues);

            // Inicialização dos centróides
            int[] centroids = initializeCentroids(values, numClusters);

            int[][] clusters;
            do {
                // Atribuição de valores aos clusters
                clusters = assignToClusters(values, centroids);

                // Atualização dos centróides
                centroids = updateCentroids(clusters);
            } while (!centroidsConverged(centroids, updateCentroids(clusters)));

            // Exibição dos resultados
            printArray("Valores originais: ", values);
            printArray("Centróides finais: ", centroids);
            printClusters("Clusters finais: ", clusters);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu uma exceção: " + e.getMessage());
        }
    }

    // Método para imprimir arrays de inteiros
    private static void printArray(String label, int[] array) {
        System.out.print(label);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // Método para imprimir arrays bidimensionais de inteiros
    private static void printClusters(String label, int[][] clusters) {
        System.out.println(label);
        for (int i = 0; i < clusters.length; i++) {
            System.out.print("Cluster " + (i + 1) + ": ");
            boolean hasValues = false;
            for (int j = 0; j < clusters[i].length; j++) {
                if (clusters[i][j] != 0) {
                    hasValues = true;
                    System.out.print(clusters[i][j]);
                    if (j < clusters[i].length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            if (!hasValues) {
                System.out.print("Nenhum valor atribuído a este cluster.");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Gera um array de valores aleatórios inteiros entre 0 e 100
    private static int[] generateRandomValues(int numValues) {
        int[] values = new int[numValues];
        Random random = new Random();
        for (int i = 0; i < numValues; i++) {
            values[i] = random.nextInt(100);
        }
        return values;
    }

    // Inicializa os centróides escolhendo valores aleatórios do conjunto de dados
    private static int[] initializeCentroids(int[] values, int numClusters) {
        if (values.length < numClusters) {
            throw new IllegalArgumentException("Número de clusters deve ser menor ou igual ao número de valores.");
        }

        Random random = new Random();
        int[] centroids = new int[numClusters];
        for (int i = 0; i < numClusters; i++) {
            centroids[i] = values[random.nextInt(values.length)];
        }
        return centroids;
    }

    // Atribui cada valor ao cluster cujo centróide é o mais próximo
    private static int[][] assignToClusters(int[] values, int[] centroids) {
        int[][] clusters = new int[centroids.length][];
        
        for (int i = 0; i < clusters.length; i++) {
            // Conta quantos valores estão no cluster para ajustar o tamanho do array
            int count = 0;
            for (int value : values) {
                if (findClosestCentroidIndex(value, centroids) == i) {
                    count++;
                }
            }
            clusters[i] = new int[count];
        }

        // Preenche os clusters com os valores
        int[] clusterCounters = new int[centroids.length];
        for (int value : values) {
            int closestCentroidIndex = findClosestCentroidIndex(value, centroids);
            int clusterIndex = closestCentroidIndex;
            int counter = clusterCounters[clusterIndex]++;
            clusters[clusterIndex][counter] = value;
        }

        return clusters;
    }

    // Encontra o índice do centróide mais próximo para um determinado valor
    private static int findClosestCentroidIndex(int value, int[] centroids) {
        int closestCentroidIndex = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < centroids.length; i++) {
            int distance = Math.abs(value - centroids[i]);
            if (distance < minDistance) {
                minDistance = distance;
                closestCentroidIndex = i;
            }
        }

        return closestCentroidIndex;
    }

    // Atualiza os centróides calculando a média de cada cluster
    private static int[] updateCentroids(int[][] clusters) {
        int[] centroids = new int[clusters.length];

        for (int i = 0; i < clusters.length; i++) {
            centroids[i] = calculateMean(clusters[i]);
        }

        return centroids;
    }

    // Calcula a média dos valores de um cluster, ignorando zeros
    private static int calculateMean(int[] values) {
        if (values.length == 0) {
            return 0;
        }

        int sum = 0;
        int count = 0;
        for (int value : values) {
            sum += value;
            count++;
        }

        return sum / count;
    }

    // Verifica se dois conjuntos de centróides convergiram com uma tolerância
    private static boolean centroidsConverged(int[] centroids1, int[] centroids2) {
        int tolerance = 1;

        for (int i = 0; i < centroids1.length; i++) {
            int diff = Math.abs(centroids1[i] - centroids2[i]);
            if (diff > tolerance) {
                return false;
            }
        }

        return true;
    }

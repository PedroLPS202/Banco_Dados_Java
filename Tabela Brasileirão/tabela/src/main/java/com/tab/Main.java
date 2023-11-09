package com.saopaulocampeao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] times = { "Paysandu", "Athletico-PR", "Atlético-MG", "Bahia", "Botafogo",
                "Amazonas-FC", "Uberaba-Sport Clube", "Cruzeiro", "Cuiabá", "Flamengo", "Fluminense", "Fortaleza",
                "São Cateano-FC", "Grêmio", "Internacional", "Portuguesa", "Bragantino", "Santos", "São Paulo",
                "Vasco da Gama"
        };

        int[] cartoesAmarelos = new int[times.length];
        int[] pontuacoes = new int[times.length];
        int[] vitorias = new int[times.length];

        while (true) {
            System.out.println("1 - Visualizar Tabela");
            System.out.println("2 - Editar Pontuação");
            System.out.println("3 - Editar Cartões Amarelos");
            System.out.println("4 - Editar Viórias");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    scanner.close();
                    return;
                case 1:
                    exibirTabela(times, pontuacoes, cartoesAmarelos, vitorias);
                    break;
                case 2:
                    editarPontuacao(times, pontuacoes, cartoesAmarelos, vitorias, scanner);
                    break;
                case 3:
                    editarCatoesAmarelos(times, pontuacoes, cartoesAmarelos, vitorias, scanner);
                    break;

                case 4:
                    editarVitorias(times, pontuacoes, cartoesAmarelos, vitorias, scanner);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        }
    }

    // Módulo para exibir a tabela
    public static void exibirTabela(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias) {
        System.out.println("\nPosição | Time | Pontuação | Cartões Amarelos | Vitórias");
        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + " | " + times[i] + " | " + pontuacoes[i] + " | " + cartoesAmarelos[i] + " | " + vitorias[i]);          
        }
    }

    // Módulo para editar a pontuação dos times
    public static void editarPontuacao(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias,
            Scanner scanner) {
        while (true) {
            System.out.println("\nTimes disponíveis para edição:");
            exibirTimes(times, pontuacoes, cartoesAmarelos, vitorias);
            System.out.println("Escolha o número do time para editar a pontuação (ou 0 para voltar):");
            int posicao = scanner.nextInt();

            if (posicao == 0) {
                break;
            }
            if (posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite a nova pontuação para " + times[posicao - 1] + ":");
                int novaPontuacao = scanner.nextInt();

                if (novaPontuacao >= 0) {
                    pontuacoes[posicao - 1] = novaPontuacao;
                } else {
                    System.out.println("A pontuação não pode ser negativa.");
                }
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }

            scanner.nextLine(); // Limpa o buffer do scanner
        }
        ordenarPorPontuacaoCartoesVitorias(times, pontuacoes, cartoesAmarelos, vitorias);
    }

    // Módulo para exibir os times disponíveis para edição
    public static void exibirTimes(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias) {
        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + " - " + times[i] + " | Pontuação: " + pontuacoes[i] + "| Cartões Amarelos: "
                    + cartoesAmarelos[i] + "Vitórias: " + vitorias[i]);
        }
    }

    /**
     * @param times
     * @param pontuacoes
     * @param cartoesAmarelos
     * @param vitorias
     * @param scanner
     */
    public static void editarVitorias(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias,
            Scanner scanner) {
        while (true) {
            System.out.println("\nTimes disponíveis para edição:");
            exibirTimes(times, pontuacoes, cartoesAmarelos, vitorias);
            System.out.println(
                    "\nEscolha o número do time para editar a quantidade de vitórias (ou clique em 0 para sair)");
            int posicao = scanner.nextInt();
            if (posicao == 0) {
                break;
            }
            if (posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite o novo número de vitórias para " + times[posicao - 1] + ":");

                int novasVitorias = scanner.nextInt();
                if (novasVitorias >= 0) {
                    vitorias[posicao - 1] = novasVitorias;
                } else {
                    System.out.println("O número de vitórias não pode ser negativo.");
                }
            } else {
                System.out.println("Posição inválida, tente novamente.");
            }
             scanner.nextLine(); // Limpa o buffer do scanner
        }
         ordenarPorPontuacaoCartoesVitorias(times, pontuacoes, cartoesAmarelos, vitorias);
    }

    // Módulo para editar os cartões amarelos dos times
    public static void editarCatoesAmarelos(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias,
            Scanner scanner) {
        while (true) {
            System.out.println("\nTimes disponíveis para edição:");
            exibirTimes(times, pontuacoes, cartoesAmarelos, vitorias);
            System.out.println("\nEscolha o número do time para editar os cartões amarelos (ou clique em 0 para sair)");
            int posicao = scanner.nextInt();
            if (posicao == 0) {
                break;
            }
            if (posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite o novo número de cartões amarelos para " + times[posicao - 1] + ":");
                int novosCartoes = scanner.nextInt();
                if (novosCartoes >= 0) {
                    cartoesAmarelos[posicao - 1] = novosCartoes;
                } else {
                    System.out.println("O número de cartões amarelos não pode ser negativo.");
                }
            } else {
                System.out.println("Posição inválida, tente novamente.");
            }
             scanner.nextLine(); // Limpa o buffer do scanner
        }
        ordenarPorPontuacaoCartoesVitorias(times, pontuacoes, cartoesAmarelos, vitorias);
    }

    // Módulo para ordenar a tabela por pontuação, cartões amarelos e vitorias
    public static void ordenarPorPontuacaoCartoesVitorias(String[] times, int[] pontuacoes, int[] cartoesAmarelos,
            int[] vitorias) {
        for (int i = 0; i < pontuacoes.length - 1; i++) {
            for (int j = i + 1; j < pontuacoes.length; j++) {
                if (pontuacoes[i] < pontuacoes[j]
                        || (pontuacoes[i] == pontuacoes[j] && cartoesAmarelos[i] > cartoesAmarelos[j])
                        || (pontuacoes[i] == pontuacoes[j] && cartoesAmarelos[i] == cartoesAmarelos[j]
                                && vitorias[i] < vitorias[j])) {
                    int tempPontuacao = pontuacoes[i];
                    pontuacoes[i] = pontuacoes[j];
                    pontuacoes[j] = tempPontuacao;

                    int tempCartoes = cartoesAmarelos[i];
                    cartoesAmarelos[i] = cartoesAmarelos[j];
                    cartoesAmarelos[j] = tempCartoes;

                    int tempVitorias = vitorias[j];
                    vitorias[j] = vitorias[i];
                    vitorias[i] = tempVitorias;

                    String tempTime = times[i];
                    times[i] = times[j];
                    times[j] = tempTime;
                }
            }
        }
    }
}

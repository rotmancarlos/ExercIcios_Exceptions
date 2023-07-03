import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadeCompras {
    public static void main(String[] args) {
        List<Alimento> listaDeCompras = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- MENU OPÇÕES -----");
            System.out.println("1. Adicionar alimento à lista de compras");
            System.out.println("2. Encerrar processo e exibir lista de compras");
            System.out.print(" Por favor escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                try {
                    System.out.print("\nInforme o tipo de alimento (VERDURAS, LEGUMES, GRÃOS ou OUTROS): ");
                    scanner.nextLine(); // Limpa o buffer do teclado
                    String tipoAlimento = scanner.nextLine().toUpperCase();

                    System.out.print("Por gentileza Informe a quantidade: ");
                    String quantidadeStr = scanner.nextLine();

                    double quantidade;
                    if (tipoAlimento.equals("VERDURAS") || tipoAlimento.equals("GRÃOS")) {
                        if (quantidadeStr.contains(".")) {
                            quantidade = Double.parseDouble(quantidadeStr);
                        } else {
                            throw new NumberFormatException("Para " + tipoAlimento + ", a quantidade deve ser informada com ponto");
                        }
                    } else if (tipoAlimento.equals("LEGUME") || tipoAlimento.equals("OUTROS")) {
                        if (!quantidadeStr.contains(".")) {
                            quantidade = Integer.parseInt(quantidadeStr);
                        } else {
                            throw new NumberFormatException("Para " + tipoAlimento + ", a quantidade deve ser informada em unidades inteiras");
                        }
                    } else {
                        throw new IllegalArgumentException("Tipo de alimento inválido");
                    }

                    if (quantidadeStr.isEmpty()) {
                        throw new UnsupportedOperationException("Não é permitido inserir valor vazio");
                    } else if (quantidade < 0) {
                        throw new IllegalArgumentException("Não é possível inserir números negativos");
                    }

                    System.out.print("Informe o nome do alimento: ");
                    String nomeAlimento = scanner.nextLine();

                    if (nomeAlimento.isEmpty()) {
                        throw new UnsupportedOperationException("Não é permitido inserir nome vazio");
                    }

                    Alimento alimento = new Alimento(nomeAlimento, tipoAlimento, quantidade);
                    listaDeCompras.add(alimento);
                } catch (NumberFormatException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (UnsupportedOperationException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.println("\n----- Lista de Compras -----");
                for (Alimento alimento : listaDeCompras) {
                    System.out.println(alimento.getNome() + " - " + alimento.getQuantidade() + " " + alimento.getTipo());
                }

                int quantidadeVerdura = 0;
                int quantidadeLegume = 0;
                int quantidadeGrao = 0;
                int quantidadeOutros = 0;

                for (Alimento alimento : listaDeCompras) {
                    switch (alimento.getTipo()) {
                        case "VERDURA":
                            quantidadeVerdura++;
                            break;
                        case "LEGUME":
                            quantidadeLegume++;
                            break;
                        case "GRÃOS":
                            quantidadeGrao++;
                            break;
                        case "OUTROS":
                            quantidadeOutros++;
                            break;
                    }
                }

                System.out.println("\nQuantidade de cada tipo de alimento:");
                System.out.println("Verdura: " + quantidadeVerdura);
                System.out.println("Legume: " + quantidadeLegume);
                System.out.println("Grãos: " + quantidadeGrao);
                System.out.println("Outros: " + quantidadeOutros);

                break;
            } else {
                System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }

        scanner.close();
    }

}

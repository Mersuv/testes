package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios25 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Digite o nome do produto (ou 'sair' para encerrar): ");
                String produto = scanner.nextLine();

                if (produto.equalsIgnoreCase("sair")){
                    break;
                }
                
            System.out.print("Digite o preço do produto: ");
            double preço = scanner.nextDouble();
            scanner.nextLine(); //consumir a quebra de linha

            System.out.println("produto: " + produto);
            System.out.println("Preço: " + preço);
            }
        }
    }
}
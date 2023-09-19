package ExerciciosPrint;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Selecione um número inteiro: ");
            int inteiro = scanner.nextInt();

            System.out.println("selecione outro: ");
            int inteiro2 = scanner.nextInt();

            double divisao = inteiro / inteiro2;
            double resto = inteiro % inteiro2;

            System.out.println("Resultado da divisão " + divisao + " e o resto " + resto);
        }

    }
}

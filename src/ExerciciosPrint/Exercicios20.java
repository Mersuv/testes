package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios20 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe a nota do aluno: ");
            double nota = scanner.nextDouble();

            if (nota >= 9) {
                System.out.println("Aprovado com louvor!");
            }else if (nota >= 7) {
                System.out.println("Aprovado!");
            }else if (nota >= 5) {
                System.out.println("Recuperação.");
            }else {
                System.out.println("Reprovado.");
            }
        }
    }
}

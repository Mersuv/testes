package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios22 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro positivo: ");
            int numero = scanner.nextInt();

            if (numero < 0) {
                System.out.println("Digite um número positivo.");
                return;
            }
            
            int fatorial = 1;
            for (int i = 1; i <= numero; i++) {
                fatorial *= i;
            }

            System.out.println("O fatorial de " + numero + " é " + fatorial);
        }
    }
}

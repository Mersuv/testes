package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios24 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro positivo: ");
            int numero = scanner.nextInt();

            if (numero <= 1) {
                System.out.println("número não é primo.");
                return;
            }

            boolean primo = true;
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.println("O número é primo.");
            } else {
                System.out.println("O número não é primo.");
            }
        }
    }
}
package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios8 {
    public static void main(String[] args) {
        try (Scanner teste = new Scanner(System.in)) {
            System.out.print("Enter an integer: ");
            int numero = teste.nextInt();

            System.out.println("You entered: " + numero);
        }

    }
}

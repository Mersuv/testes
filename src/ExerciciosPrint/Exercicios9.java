package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios9 {
    public static void main(String[] args) {
        try (Scanner teste = new Scanner(System.in)) {
            System.out.print("Enter a decimal number: ");
            double numeroDecimal = teste.nextDouble();

            System.out.println("You entered: " + numeroDecimal);
        }
    }
}

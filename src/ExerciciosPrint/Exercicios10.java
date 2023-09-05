package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios10 {
    public static void main(String[] args) {
        try (Scanner teste = new Scanner(System.in)) {
            System.out.print("Enter a line of text: ");
            String texto = teste.nextLine();

            System.out.println("You entered: " + texto);
        }
    }
}

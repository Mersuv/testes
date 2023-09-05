package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios12 {
    public static void main(String[] args) {
        try (Scanner texto = new Scanner(System.in)) {
            System.out.print("Enter full name: ");
            String nome = texto.nextLine();

            System.out.println("Your full name is: "+ nome);
        }
    }
}

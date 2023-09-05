package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios15 {
    public static void main(String [] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a sentence: ");
            String sentence = scanner.nextLine();

            System.out.println("Characters in the sentence: " + sentence.length());
        }
    }
}

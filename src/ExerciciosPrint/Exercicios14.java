package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios14 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a date in the format DD/MM/YYYY: ");
            String date = scanner.next();

            System.out.println("You entered the date: " + date);
        }
    }
}

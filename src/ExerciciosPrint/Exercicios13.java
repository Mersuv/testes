package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios13 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of values: ");
            int count = scanner.nextInt();
            scanner.nextLine();// Consuming the newline character

            double sum = 0;

            for (int i = 1; i <= count; i++){
                System.out.print("Enter value " + i + ": ");
                double value = scanner.nextDouble();
                sum += value;
                scanner.nextLine(); //Consuming the new line character
            }

            double average = sum / count;
            System.out.println("Average: " + average);
        }
    }
}
package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios11 {
    public static void main(String[] args) {
        try (Scanner teste = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String nome = teste.nextLine();

            System.out.print("Enter your age: ");
            int idade = teste.nextInt();
            teste.nextLine();

            System.out.println("Hello, " + nome + "!You are " + idade + " years old.");
        }
    }
}

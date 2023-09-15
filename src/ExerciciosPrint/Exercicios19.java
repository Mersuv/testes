package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios19 {
    public static void main(String [] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Informe seu nome: ");
            String nome = scanner.nextLine();

            System.out.println("Olá, " + nome + "! Bem-vindo ao nosso programa.");
        }
    }
}

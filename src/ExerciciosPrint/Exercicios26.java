package ExerciciosPrint;

import java.util.Scanner;
import java.util.Random;

public class Exercicios26 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            int numeroSecreto = random.nextInt(100) + 1; // Gera um número aleatório de 1 a 100

            int tentativas = 0;
            boolean acertou = false;

            System.out.println("Bem-vindo ao Jogo de Adivinhação!");
            System.out.println("Tente adivinhar o número secreto de 1 a 100.");

            while (!acertou) {
                System.out.print("Digite um número: ");
                int tentativa = scanner.nextInt();
                tentativas++;

                if (tentativa == numeroSecreto) {
                    acertou = true;
                    System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas.");
                } else if (tentativa < numeroSecreto) { //Se deixar só como if ele gera "Tente um número menor" depois do "Parabéns"
                    System.out.println("Tente um número maior.");
                } else {
                    System.out.println("Tente um número menor.");
                }
            }
        }
    }
}

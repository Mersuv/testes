package Beecrowd;

import java.util.Scanner;

public class Bee2861 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o número de perguntas
        int C = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número

        // Processa as perguntas
        for (int i = 0; i < C; i++) {
            String pergunta = scanner.nextLine();
            String resposta = responderAmigos(pergunta);
            System.out.println(resposta);
        }

        scanner.close();
    }

    // Função para simular a resposta dos amigos
    public static String responderAmigos(String pergunta) {
        return "gzuz";
    }
}

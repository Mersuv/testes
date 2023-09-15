package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios18 {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Informe o primeiro número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Informe o segundo número: ");
            double num2 = scanner.nextDouble();

            System.out.println("Escolha uma operação: ");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");

            int escolha = scanner.nextInt();
            double resultado = 0;

            switch (escolha) {
                case 1:
                    resultado = num1 + num2;
                    break;
                case 2:
                    resultado = num1 - num2;
                    break;
                case 3:
                    resultado = num1 * num2;
                    break;
                case 4:
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        System.out.println("Divisão por zero não é permitida.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }
            System.out.println("Resultado: " + resultado);
        }
    }
}

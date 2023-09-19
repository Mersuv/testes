package ExerciciosPrint;

import java.util.Scanner;

public class FiapImc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite seu peso: ");
        double peso = scan.nextDouble();

        System.out.print("Digite sua altura: ");
        double altura = scan.nextDouble();

        double imc = peso / (altura + altura);

        if (imc >= 26) {
            System.out.println("Seu imc é: " + imc + "Você está acima do peso ");
        } else if (imc <= 18.5) {
            System.out.println("Seu imc é: "+ imc + " voce está abaixo do peso.");
        } if() {
            System.out.println("ok");
        }
    }
}

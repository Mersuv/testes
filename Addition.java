//Figura 2.7: Addition.java
//programa de adição que insere dois números, então exibe a soma deles.
import java.util.Scanner; //programa utiliza a classe Scanner

public class Addition {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int number1; //primeiros numero a somar
            int number2; // segundo numero a somar
            int sum; // soma de number1 e number 2

            System.out.print("Digite o primeiro número: "); //prompt
            number1 = input.nextInt(); //le primeiro o numero fornecido pelo usuário

            System.out.print("Digite o segundo número: "); //prompt
            number2 = input.nextInt(); // le o segundo numero fornecido pelo usuário

            sum = number1 + number2; // soma os números, depois armazena o total em sum

            System.out.printf("Sum is %d%n", sum); // exibe a soma
        }
    }// fim do método main
}//fim da classe addition


//System.out.printf("Sum is %d%n", (number1 + number2));  pode substituir as instruções acima

// o Try foi adicionado conforme um erro que aparece e foi cogitado pelo programa o uso do mesmo
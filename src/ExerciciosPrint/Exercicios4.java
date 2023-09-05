package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios4 {
    public static void main(String [] args){
        try (Scanner teste = new Scanner(System.in)) { //sempre pede para colocar o try 
            System.out.print("Enter your name: ");
            String name = teste.nextLine();
            System.out.println("Hello, " + name + "!");
        }
    }
}

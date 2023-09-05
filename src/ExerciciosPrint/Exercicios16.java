package ExerciciosPrint;

import java.util.Scanner;

public class Exercicios16 {
    public static void main(String[]args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Do you want to continue (yes/no)? ");
            String response = scanner.nextLine().toLowerCase();

            if (response.equals("yes")){
                System.out.println("You chose to continue.");
            } else if (response.equals("no")){
                System.out.println("You chose to exit.");
            } else {
                System.out.println("Invalid response.");
            }
        }
    }
}

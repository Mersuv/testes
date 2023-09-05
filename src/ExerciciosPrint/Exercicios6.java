package ExerciciosPrint;

public class Exercicios6 {
    public static void main(String[] args) {
        String message = "Welcome to Java Programming!";
        int charCount = message.replaceAll(" ", "").length();
        System.out.println("Character count (excluding spaces): " + charCount);
    }
}

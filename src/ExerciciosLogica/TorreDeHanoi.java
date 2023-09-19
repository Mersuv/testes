package ExerciciosLogica;

public class TorreDeHanoi {
    public static void moverDisco(int n, char hasteOrigem, char hasteDestino, char hasteAuxiliar) {
        if (n == 1) {
            System.out.println("Mova disco 1 da haste " + hasteOrigem + " para a haste " + hasteDestino);
            return;
        }

        moverDisco(n - 1, hasteOrigem, hasteAuxiliar, hasteDestino);
        System.out.println("Mova disco " + n + " da haste " + hasteOrigem + " para a haste " + hasteDestino);
        moverDisco(n - 1, hasteAuxiliar, hasteDestino, hasteOrigem);
    }

    public static void main(String[] args) {
        int numeroDeDiscos = 3; // Altere o número de discos conforme necessário
        moverDisco(numeroDeDiscos, 'A', 'C', 'B');
    }
}

package ExerciciosLogica;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class EnchendoBarris1 {

    // Classe para representar o estado atual dos barris
    static class Estado {
        int barrilA, barrilB, barrilC;

        Estado(int a, int b, int c) {
            barrilA = a;
            barrilB = b;
            barrilC = c;
        }

        @Override
        public int hashCode() {
            return 31 * (31 * barrilA + barrilB) + barrilC;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Estado other = (Estado) obj;
            return barrilA == other.barrilA && barrilB == other.barrilB && barrilC == other.barrilC;
        }

        @Override
        public String toString() {
            return "A=" + barrilA + " B=" + barrilB + " C=" + barrilC;
        }
    }

    // Função para verificar se a situação atual é válida
    static boolean eValido(int a, int b, int c) {
        return a >= 0 && b >= 0 && c >= 0 && a <= 8 && b <= 5 && c <= 3;
    }

    // Função para verificar se chegamos à solução desejada
    static boolean eSolução(int a, int b, int c) {
        return a == 4 && b == 4 && c == 0;
    }

    public static void main(String[] args) {
        // Estado inicial
        Estado estadoInicial = new Estado(8, 0, 0);

        // Fila para busca em largura
        Queue<Estado> fila = new ArrayDeque<>();
        fila.add(estadoInicial);

        // Conjunto para evitar ciclos
        Set<Estado> visitados = new HashSet<>();
        visitados.add(estadoInicial);

        // Busca em largura
        while (!fila.isEmpty()) {
            Estado estadoAtual = fila.poll();
            int a = estadoAtual.barrilA;
            int b = estadoAtual.barrilB;
            int c = estadoAtual.barrilC;

            if (eSolução(a, b, c)) {
                System.out.println("Solução encontrada:");
                System.out.println(estadoAtual);
                break;
            }

            // Gerar todas as ações possíveis
            Estado[] acoes = {
                    new Estado(a - 5, b + 5, c),
                    new Estado(a - 3, b, c + 3),
                    new Estado(a + 5, b - 5, c),
                    new Estado(a, b - 3, c + 3),
                    new Estado(a + 3, b, c - 3),
                    new Estado(a, b + 3, c - 3)
            };

            for (Estado novaAção : acoes) {
                if (eValido(novaAção.barrilA, novaAção.barrilB, novaAção.barrilC) &&
                        !visitados.contains(novaAção)) {
                    fila.add(novaAção);
                    visitados.add(novaAção);
                    System.out.println("Ação: " + novaAção);
                }
            }
        }
    }
}

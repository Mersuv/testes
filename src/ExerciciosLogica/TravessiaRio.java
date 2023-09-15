package ExerciciosLogica;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * TravessiaRio
 */
public class TravessiaRio {

    static class Estado {
        int jesuítasEsquerda;
        int canibaisEsquerda;
        int barco;
        int jesuítasDireita;
        int canibaisDireita;
        Estado pai; // Adicionado para rastrear o estado anterior

        Estado(int jE, int cE, int b, int jD, int cD) {
            jesuítasEsquerda = jE;
            canibaisEsquerda = cE;
            barco = b;
            jesuítasDireita = jD;
            canibaisDireita = cD;
        }

        boolean eValido() {
            // Verifica se a quantidade de canibais não excede a de jesuítas em ambos os
            // lados
            return (jesuítasEsquerda == 0 || jesuítasEsquerda >= canibaisEsquerda)
                    && (jesuítasDireita == 0 || jesuítasDireita >= canibaisDireita);
        }

        boolean eObjetivo() {
            // Verifica se todos chegaram ao outro lado do rio
            return jesuítasEsquerda == 0 && canibaisEsquerda == 0;
        }
        
        Estado[] gerarSucessores() {
            Estado[] sucessores = new Estado[8];
            int idx = 0;

            if (barco == 1) {
                for (int j = 0; j <= 2; j++) {
                    for (int c = 0; c <= 2; c++) {
                        if (j + c >= 1 && j + c <= 2) {
                            Estado sucessor = new Estado(
                                    jesuítasEsquerda + (barco == 1 ? -j : j),
                                    canibaisEsquerda + (barco == 1 ? -c : c),
                                    1 - barco,
                                    jesuítasDireita + (barco == 1 ? j : -j),
                                    canibaisDireita + (barco == 1 ? c : -c));

                            if (sucessor.eValido()) {
                                sucessor.pai = this; // Define o pai do sucessor como o estado atual
                                sucessores[idx++] = sucessor;
                            }
                        }
                    }
                }
            } else {
                for (int j = 0; j <= 2; j++) {
                    for (int c = 0; c <= 2; c++) {
                        if (j + c >= 1 && j + c <= 2) {
                            Estado sucessor = new Estado(
                                    jesuítasEsquerda + j,
                                    canibaisEsquerda + c,
                                    1,
                                    jesuítasDireita - j,
                                    canibaisDireita - c);

                            if (sucessor.eValido()) {
                                sucessor.pai = this; // Define o pai do sucessor como o estado atual
                                sucessores[idx++] = sucessor;
                            }
                        }
                    }
                }
            }
            
            return Arrays.copyOf(sucessores, idx);
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Estado estado = (Estado) o;
            return jesuítasEsquerda == estado.jesuítasEsquerda &&
                    canibaisEsquerda == estado.canibaisEsquerda &&
                    barco == estado.barco &&
                    jesuítasDireita == estado.jesuítasDireita &&
                    canibaisDireita == estado.canibaisDireita;
        }

        @Override
        public int hashCode() {
            return Objects.hash(jesuítasEsquerda, canibaisEsquerda, barco, jesuítasDireita, canibaisDireita);
        }
    }

    public static void main(String[] args) {
        Set<Estado> visitados = new HashSet<>();
        Queue<Estado> fila = new ArrayDeque<>();
        Estado estadoInicial = new Estado(3, 3, 1, 0, 0);
        fila.add(estadoInicial);

        while (!fila.isEmpty()) {
            Estado estadoAtual = fila.poll();
            visitados.add(estadoAtual);

            if (estadoAtual.eObjetivo()) {
                System.out.println("Solução encontrada!");
                exibirCaminho(estadoAtual);
                break;
            }

            for (Estado sucessor : estadoAtual.gerarSucessores()) {
                if (sucessor.eValido() && !visitados.contains(sucessor)) {
                    fila.add(sucessor);
                }
            }
        }
    }

    static void exibirCaminho(Estado estadoFinal) {
        System.out.println("Caminho da solução:");
        Estado estado = estadoFinal;
        while (estado != null) {
            System.out.println("Barco na " + (estado.barco == 0 ? "esquerda" : "direita") +
                    ": Jesuítas na esquerda: " + estado.jesuítasEsquerda +
                    ", Canibais na esquerda: " + estado.canibaisEsquerda +
                    ", Jesuítas na direita:" + estado.jesuítasDireita +
                    ", Canibais na direita: " + estado.canibaisDireita);
            estado = estado.pai;
        }
    }
}
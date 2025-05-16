import java.util.*;

public class SubconjuntosTamanhoN {
    public static void main(String[] args) {
        List<Integer> S = Arrays.asList(1, 2, 3);
        int N = 2;

        List<List<Integer>> resultado = gerarSubconjuntos(S, N);

        System.out.println("Subconjuntos de tamanho " + N + ":");
        for (List<Integer> subconjunto : resultado) {
            System.out.println(subconjunto);
        }
    }

    public static List<List<Integer>> gerarSubconjuntos(List<Integer> S, int N) {
        List<List<Integer>> resultado = new ArrayList<>();
        backtrack(S, N, 0, new ArrayList<>(), resultado);
        return resultado;
    }

    private static void backtrack(List<Integer> S, int N, int inicio, List<Integer> atual, List<List<Integer>> resultado) {
        if (atual.size() == N) {
            resultado.add(new ArrayList<>(atual));
            return;
        }

        for (int i = inicio; i < S.size(); i++) {
            atual.add(S.get(i));
            backtrack(S, N, i + 1, atual, resultado);
            atual.remove(atual.size() - 1); // desfaz o último passo (backtrack)
        }
    }
}

package modulo2;

public class Problema3FibonacciComplexidade {

    // RECURSIVA SIMPLES - O(2^n)
    // deixei aqui so pra comparar com a PD
    // cada chamada gera mais duas, recalcula os mesmos valores varias vezes
    // fib(3) aparece 2x, fib(2) aparece 3x so pra calcular fib(5)
    // pra numeros grandes fica inviavel muito rapido
    public static int fibRecursivo(int n) {
        // condicao de parada
        if (n <= 1) {
            return n;
        }
        return fibRecursivo(n - 1) + fibRecursivo(n - 2);
    }

    // TOP-DOWN com memoizacao - O(n)
    // ainda usa recursao mas guarda os resultados no memo
    // antes de calcular, verifica se ja calculei antes
    // cada valor e calculado so uma vez
    static int[] memo = new int[1001];

    public static int fibTopDown(int n) {
        // condicao de parada
        if (n <= 1) {
            return n;
        }
        // se ja calculei, nao precisa calcular de novo
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
        return memo[n];
    }

    // BOTTOM-UP com tabulacao - O(n)
    // sem recursao, começa do caso base e vai subindo com um laco
    // cada posicao usa os dois valores anteriores, que ja foram calculados
    // por que a PD e melhor que a recursiva?
    // porque elimina o recalculo, cada subproblema e resolvido so uma vez
    public static int fibBottomUp(int n) {
        // condicao de parada
        if (n <= 1) {
            return n;
        }

        int[] tabela = new int[n + 1];
        tabela[0] = 0;
        tabela[1] = 1;

        for (int i = 2; i <= n; i++) {
            tabela[i] = tabela[i - 1] + tabela[i - 2];
        }

        return tabela[n];
    }

    public static void main(String[] args) {
        int n = 40;

        System.out.println("Calculando fib(" + n + ")...\n");

        // recursiva - demora bastante pra n grande
        long inicio = System.currentTimeMillis();
        int resultadoRecursivo = fibRecursivo(n);
        long fimRecursivo = System.currentTimeMillis();

        System.out.println("Recursiva O(2^n):");
        System.out.println("  Resultado: " + resultadoRecursivo);
        System.out.println("  Tempo: " + (fimRecursivo - inicio) + "ms");

        // top-down
        long inicioTD = System.currentTimeMillis();
        int resultadoTopDown = fibTopDown(n);
        long fimTD = System.currentTimeMillis();

        System.out.println("\nTop-Down O(n):");
        System.out.println("  Resultado: " + resultadoTopDown);
        System.out.println("  Tempo: " + (fimTD - inicioTD) + "ms");

        // bottom-up
        long inicioBU = System.currentTimeMillis();
        int resultadoBottomUp = fibBottomUp(n);
        long fimBU = System.currentTimeMillis();

        System.out.println("\nBottom-Up O(n):");
        System.out.println("  Resultado: " + resultadoBottomUp);
        System.out.println("  Tempo: " + (fimBU - inicioBU) + "ms");
    }
}

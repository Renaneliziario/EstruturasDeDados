package modulo2;

public class Problema2FatorialPD {

    // TOP-DOWN: começa do n e vai descendo recursivamente
    // antes de calcular, verifica se ja calculei antes (memo)
    // se ja tem no memo, so retorna sem calcular de novo
    static long[] memo = new long[21];

    public static long fatorialTopDown(int n) {
        // condicao de parada
        if (n == 0 || n == 1) {
            return 1;
        }
        // se ja calculei esse valor, nao preciso calcular de novo
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = n * fatorialTopDown(n - 1);
        return memo[n];
    }

    // BOTTOM-UP: começa do caso base (0 e 1) e vai subindo com um laco
    // nao usa recursao, preenche uma tabela do menor pro maior
    // cada posicao usa o valor da posicao anterior, que ja foi calculada
    public static long fatorialBottomUp(int n) {
        // condicao de parada / caso base
        if (n == 0 || n == 1) {
            return 1;
        }

        long[] tabela = new long[n + 1];
        tabela[0] = 1; // 0! = 1
        tabela[1] = 1; // 1! = 1

        for (int i = 2; i <= n; i++) {
            tabela[i] = i * tabela[i - 1];
        }

        return tabela[n];
    }

    // diferenca entre exercicio 2 e 3:
    // exercicio 2 (recursao simples): nao guarda resultados, recalcula tudo sempre
    // top-down: usa recursao mas guarda os resultados no memo pra nao repetir
    // bottom-up: sem recursao, mais seguro pra numeros grandes, sem risco de estouro de pilha
    public static void main(String[] args) {
        System.out.println("=== TOP-DOWN ===");
        System.out.println("Fatorial de 3: " + fatorialTopDown(3));   // 6
        System.out.println("Fatorial de 7: " + fatorialTopDown(7));   // 5040
        System.out.println("Fatorial de 15: " + fatorialTopDown(15)); // 1307674368000

        System.out.println("\n=== BOTTOM-UP ===");
        System.out.println("Fatorial de 3: " + fatorialBottomUp(3));   // 6
        System.out.println("Fatorial de 7: " + fatorialBottomUp(7));   // 5040
        System.out.println("Fatorial de 15: " + fatorialBottomUp(15)); // 1307674368000
    }
}

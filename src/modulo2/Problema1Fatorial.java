package modulo2;

public class Problema1Fatorial {

    // uso long porque int estoura ja no 13!
    // long aguenta ate o 20!, acima disso o resultado fica errado
    public static long fatorial(int n) {
        // condicao de parada: fatorial de 0 e 1 e sempre 1
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }

    // consegue calcular fatorial acima de 100 com recursao?
    // a pilha de chamadas aguenta (100 niveis e pouco pra JVM)
    // mas o long estoura no 21!, entao o resultado seria errado
    // precisaria usar BigInteger pra guardar numeros tao grandes
    public static void main(String[] args) {
        System.out.println("Fatorial de 3: " + fatorial(3));   // 6
        System.out.println("Fatorial de 7: " + fatorial(7));   // 5040
        System.out.println("Fatorial de 10: " + fatorial(10)); // 3628800
        System.out.println("Fatorial de 20: " + fatorial(20)); // 2432902008176640000
        System.out.println("Fatorial de 21 (overflow!): " + fatorial(21)); // resultado errado
    }
}

public class Pilha {

    // A pilha usa um array internamente para guardar os inteiros.
    // "topo" rastreia o índice do elemento mais recente.
    private int[] elementos;
    private int topo;

    // Construtor: define o tamanho máximo da pilha ao criar.
    public Pilha(int capacidade) {
        elementos = new int[capacidade];
        topo = -1; // -1 significa que a pilha está vazia
    }

    // Coloca um inteiro no topo da pilha.
    public void push(int valor) {
        topo++;
        elementos[topo] = valor;
    }

    // Remove o valor do topo e o retorna.
    public int pop() {
        int valorDoTopo = elementos[topo];
        topo--;
        return valorDoTopo;
    }

    // Retorna o valor do topo sem remover.
    public int top() {
        return elementos[topo];
    }

    // Retorna true se a pilha estiver vazia, false caso contrário.
    public boolean isEmpty() {
        return topo == -1;
    }

    // Retorna quantos elementos existem na pilha.
    public int size() {
        return topo + 1; // topo começa em -1, então somamos 1
    }

    // Método main para testar tudo
    public static void main(String[] args) {
        Pilha pilha = new Pilha(10);

        System.out.println("Pilha vazia? " + pilha.isEmpty()); // true

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Tamanho: " + pilha.size());   // 3
        System.out.println("Topo: " + pilha.top());       // 30
        System.out.println("Pop: " + pilha.pop());        // 30 (removido)
        System.out.println("Novo topo: " + pilha.top()); // 20
        System.out.println("Tamanho: " + pilha.size());   // 2
    }
}

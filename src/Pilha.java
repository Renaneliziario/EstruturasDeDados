public class Pilha {

    private int[] elementos;
    private int topo;

    public Pilha(int capacidade) {
        elementos = new int[capacidade];
        topo = -1;
    }

    public void push(int valor) {
        topo++;
        elementos[topo] = valor;
    }

    public int pop() {
        int valorDoTopo = elementos[topo];
        topo--;
        return valorDoTopo;
    }

    public int top() {
        return elementos[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int size() {
        return topo + 1;
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha(10);

        System.out.println("Pilha vazia? " + pilha.isEmpty());

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Tamanho: " + pilha.size());
        System.out.println("Topo: " + pilha.top());
        System.out.println("Pop: " + pilha.pop());
        System.out.println("Novo topo: " + pilha.top());
        System.out.println("Tamanho: " + pilha.size());
    }
}

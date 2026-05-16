public class Fila {

    private int[] elementos;
    private int frente;
    private int fim;
    private int tamanho;

    public Fila(int capacidade) {
        elementos = new int[capacidade];
        frente = 0;
        fim = 0;
        tamanho = 0;
    }

    public void enqueue(int valor) {
        elementos[fim] = valor;
        fim++;
        tamanho++;
    }

    public int dequeue() {
        int valor = elementos[frente];
        frente++;
        tamanho--;
        return valor;
    }

    public int front() {
        return elementos[frente];
    }

    public int rear() {
        return elementos[fim - 1];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public int size() {
        return tamanho;
    }

    public static void main(String[] args) {
        Fila fila = new Fila(10);

        System.out.println("Fila vazia? " + fila.isEmpty());

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println("Tamanho: " + fila.size());
        System.out.println("Frente: " + fila.front());
        System.out.println("Fim: " + fila.rear());
        System.out.println("Dequeue: " + fila.dequeue());
        System.out.println("Nova frente: " + fila.front());
        System.out.println("Tamanho: " + fila.size());
    }
}

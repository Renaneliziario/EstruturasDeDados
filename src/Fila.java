// =============================================================
// EXERCÍCIO 2 — FILA (FIFO: First In, First Out)
// =============================================================
// Imagine uma fila de banco: quem chega primeiro é atendido primeiro.
// Novos elementos entram pelo FIM da fila.
// Elementos saem pela FRENTE da fila.
//
// Usamos um array para guardar os elementos.
// Duas variáveis controlam as posições:
//   - "frente": índice do próximo elemento a sair
//   - "fim":    índice da próxima posição disponível para entrar
//
// Visualização após enqueue(10), enqueue(20), enqueue(30):
//
//   índice:  [0]  [1]  [2]  [3] ...
//   array:    10   20   30   _
//             ↑              ↑
//           frente          fim
//
// Após dequeue() — remove o 10 (frente):
//
//   índice:  [0]  [1]  [2]  [3] ...
//   array:    10   20   30   _
//                  ↑         ↑
//               frente      fim   (frente avançou, 10 foi removido)
// =============================================================

public class Fila {

    private int[] elementos; // array que armazena os inteiros da fila
    private int frente;      // índice do elemento que vai sair primeiro
    private int fim;         // índice onde o próximo elemento vai entrar
    private int tamanho;     // quantidade atual de elementos na fila

    // -------------------------------------------------------------
    // Construtor: cria a fila com um tamanho máximo definido.
    // "frente" e "fim" começam em 0 (fila vazia, ambos no início).
    // -------------------------------------------------------------
    public Fila(int capacidade) {
        elementos = new int[capacidade];
        frente = 0;
        fim = 0;
        tamanho = 0;
    }

    // -------------------------------------------------------------
    // enqueue(valor): adiciona um inteiro ao FIM da fila.
    //
    // 1. Coloca o valor na posição apontada por "fim"
    // 2. Avança "fim" para a próxima posição livre
    //
    // Antes de enqueue(30):  [10, 20,  _,  _]   fim aponta para índice 2
    // Depois de enqueue(30): [10, 20, 30,  _]   fim avança para índice 3
    // -------------------------------------------------------------
    public void enqueue(int valor) {
        elementos[fim] = valor; // coloca o valor na próxima posição livre
        fim++;                  // avança o fim para a posição seguinte
        tamanho++;              // um elemento a mais na fila
    }

    // -------------------------------------------------------------
    // dequeue(): remove o inteiro da FRENTE da fila e o retorna.
    //
    // 1. Salva o valor da frente para retornar
    // 2. Avança "frente" para o próximo elemento
    //
    // Antes de dequeue():  [10, 20, 30]   frente aponta para índice 0
    // Depois de dequeue(): [10, 20, 30]   frente avança para índice 1
    //                       (o 10 não é apagado, mas não pertence mais à fila)
    // -------------------------------------------------------------
    public int dequeue() {
        int valor = elementos[frente]; // salva o valor da frente
        frente++;                      // frente avança, ignorando o elemento removido
        tamanho--;                     // um elemento a menos na fila
        return valor;
    }

    // -------------------------------------------------------------
    // front(): retorna o inteiro que está na FRENTE da fila.
    // Apenas lê o valor — não remove nada.
    // -------------------------------------------------------------
    public int front() {
        return elementos[frente];
    }

    // -------------------------------------------------------------
    // rear(): retorna o inteiro que está no FIM da fila.
    // "fim" aponta para a próxima posição livre, então o último
    // elemento está na posição "fim - 1".
    // -------------------------------------------------------------
    public int rear() {
        return elementos[fim - 1];
    }

    // -------------------------------------------------------------
    // isEmpty(): retorna true se não houver nenhum elemento na fila.
    // Usamos "tamanho" para verificar, pois é a forma mais direta.
    // -------------------------------------------------------------
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // -------------------------------------------------------------
    // size(): retorna quantos elementos existem na fila no momento.
    // -------------------------------------------------------------
    public int size() {
        return tamanho;
    }

    // -------------------------------------------------------------
    // Método main para testar todos os métodos acima
    // -------------------------------------------------------------
    public static void main(String[] args) {
        Fila fila = new Fila(10);

        System.out.println("Fila vazia? " + fila.isEmpty()); // true

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        // Estado do array agora:
        // índice:  [0]  [1]  [2]  [3] ...
        // array:    10   20   30   _
        //           ↑              ↑
        //         frente          fim

        System.out.println("Tamanho: " + fila.size());      // 3
        System.out.println("Frente: " + fila.front());      // 10
        System.out.println("Fim: " + fila.rear());          // 30
        System.out.println("Dequeue: " + fila.dequeue());   // 10 (removido)
        System.out.println("Nova frente: " + fila.front()); // 20
        System.out.println("Tamanho: " + fila.size());      // 2
    }
}

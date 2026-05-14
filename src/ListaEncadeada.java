// =============================================================
// EXERCÍCIO 3 — LISTA ENCADEADA (Linked List)
// =============================================================
// Uma lista encadeada é uma sequência de nodes onde cada node
// guarda um valor e aponta para o próximo node da lista.
//
// Diferente do array, os elementos não ficam lado a lado na
// memória — eles ficam espalhados, conectados pelos ponteiros.
//
// Visualização de uma lista com três elementos:
//
//   head → [10 | •] → [20 | •] → [30 | null]
//           índice 0    índice 1    índice 2
//
// "head" aponta para o primeiro node.
// O último node aponta para null (fim da lista).
// =============================================================

public class ListaEncadeada {

    // -------------------------------------------------------------
    // CLASSE NODE
    // Cada elemento da lista é um node com um valor inteiro
    // e uma referência para o próximo node.
    // Não é privada pois os métodos retornam Node diretamente.
    // -------------------------------------------------------------
    public static class Node {
        int valor;
        Node proximo;

        Node(int valor) {
            this.valor = valor;
        }
    }

    // -------------------------------------------------------------
    // ATRIBUTOS DA LISTA
    // "head" aponta para o primeiro node da lista.
    // Quando a lista está vazia, head é null.
    // -------------------------------------------------------------
    private Node head;
    private int tamanho;

    // Construtor: lista começa vazia
    public ListaEncadeada() {
        head = null;
        tamanho = 0;
    }

    // -------------------------------------------------------------
    // push(node): adiciona um node ao FIM da lista.
    //
    // Caso 1 — lista vazia: o node vira o head.
    // Caso 2 — lista com elementos: caminhamos até o último node
    //          e fazemos ele apontar para o novo node.
    //
    // Antes:  head → [10] → [20] → null
    // Depois: head → [10] → [20] → [30] → null
    // -------------------------------------------------------------
    public void push(Node node) {
        if (head == null) {
            // lista vazia: o novo node é o primeiro e único elemento
            head = node;
        } else {
            // caminha até o último node da lista
            Node atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo; // avança para o próximo node
            }
            // atual agora é o último node — faz ele apontar para o novo
            atual.proximo = node;
        }
        tamanho++;
    }

    // -------------------------------------------------------------
    // pop(): remove o node do FIM da lista e o retorna.
    //
    // Caso especial: se só há um elemento, head vira null.
    // Caso geral: caminhamos até o penúltimo node e cortamos
    //             a ligação com o último.
    //
    // Antes:  head → [10] → [20] → [30] → null
    // Depois: head → [10] → [20] → null   (retorna o node com 30)
    // -------------------------------------------------------------
    public Node pop() {
        if (head.proximo == null) {
            // só existe um elemento na lista
            Node ultimo = head;
            head = null; // lista fica vazia
            tamanho--;
            return ultimo;
        }

        // caminha até o penúltimo node
        Node atual = head;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        // atual agora é o penúltimo — salva o último e corta a ligação
        Node ultimo = atual.proximo;
        atual.proximo = null; // o penúltimo vira o novo último
        tamanho--;
        return ultimo;
    }

    // -------------------------------------------------------------
    // insert(index, node): adiciona um node em uma posição específica.
    //
    // Caso especial: inserir na posição 0 substitui o head.
    // Caso geral: caminhamos até o node ANTERIOR à posição desejada
    //             e encaixamos o novo node entre ele e o próximo.
    //
    // Inserindo na posição 1 (entre 10 e 20):
    //   Antes:  head → [10] → [20] → [30] → null
    //   Depois: head → [10] → [99] → [20] → [30] → null
    // -------------------------------------------------------------
    public void insert(int index, Node node) {
        if (index == 0) {
            // inserir no início: novo node aponta para o antigo head
            node.proximo = head;
            head = node; // novo node vira o head
            tamanho++;
            return;
        }

        // caminha até o node na posição anterior ao índice desejado
        Node atual = head;
        for (int i = 0; i < index - 1; i++) {
            atual = atual.proximo;
        }

        // encaixa o novo node entre "atual" e o próximo de "atual"
        node.proximo = atual.proximo; // novo node aponta para quem estava depois
        atual.proximo = node;         // anterior aponta para o novo node
        tamanho++;
    }

    // -------------------------------------------------------------
    // remove(index): remove o node em uma posição específica.
    //
    // Caso especial: remover na posição 0 substitui o head.
    // Caso geral: caminhamos até o node ANTERIOR ao que será removido
    //             e pulamos o node removido na cadeia de ponteiros.
    //
    // Removendo o índice 1 (node com valor 20):
    //   Antes:  head → [10] → [20] → [30] → null
    //   Depois: head → [10] → [30] → null
    // -------------------------------------------------------------
    public void remove(int index) {
        if (index == 0) {
            // remover o primeiro: head passa a ser o segundo node
            head = head.proximo;
            tamanho--;
            return;
        }

        // caminha até o node anterior ao que será removido
        Node atual = head;
        for (int i = 0; i < index - 1; i++) {
            atual = atual.proximo;
        }

        // pula o node removido: anterior aponta direto para o próximo do removido
        atual.proximo = atual.proximo.proximo;
        tamanho--;
    }

    // -------------------------------------------------------------
    // elementAt(index): retorna o node em uma posição específica.
    //
    // Caminhamos pela lista contando os passos até chegar ao índice.
    // Não é possível acessar direto como num array — temos que
    // percorrer desde o início.
    // -------------------------------------------------------------
    public Node elementAt(int index) {
        Node atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo; // avança um node por iteração
        }
        return atual;
    }

    // -------------------------------------------------------------
    // size(): retorna quantos nodes existem na lista.
    // -------------------------------------------------------------
    public int size() {
        return tamanho;
    }

    // -------------------------------------------------------------
    // printList(): exibe todos os elementos da lista em sequência.
    //
    // Percorre do head até o null, imprimindo cada valor.
    // Exemplo de saída: 10 → 20 → 30 → null
    // -------------------------------------------------------------
    public void printList() {
        Node atual = head;
        while (atual != null) {
            System.out.print(atual.valor);
            if (atual.proximo != null) {
                System.out.print(" → ");
            }
            atual = atual.proximo;
        }
        System.out.println(" → null");
    }

    // -------------------------------------------------------------
    // Método main para testar
    // -------------------------------------------------------------
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        // push: adiciona ao fim
        lista.push(new Node(10));
        lista.push(new Node(20));
        lista.push(new Node(30));
        lista.printList(); // 10 → 20 → 30 → null

        // insert: insere o 99 na posição 1 (entre 10 e 20)
        lista.insert(1, new Node(99));
        lista.printList(); // 10 → 99 → 20 → 30 → null

        // remove: remove o node na posição 1 (o 99)
        lista.remove(1);
        lista.printList(); // 10 → 20 → 30 → null

        // elementAt: retorna o node na posição 2
        Node node = lista.elementAt(2);
        System.out.println("Elemento no índice 2: " + node.valor); // 30

        // pop: remove o último
        Node removido = lista.pop();
        System.out.println("Pop: " + removido.valor); // 30
        lista.printList(); // 10 → 20 → null

        System.out.println("Tamanho: " + lista.size()); // 2
    }
}

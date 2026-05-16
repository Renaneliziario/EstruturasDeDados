public class ListaEncadeada {

    public static class Node {
        int valor;
        Node proximo;

        Node(int valor) {
            this.valor = valor;
        }
    }

    private Node head;
    private int tamanho;

    public ListaEncadeada() {
        head = null;
        tamanho = 0;
    }

    public void push(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = node;
        }
        tamanho++;
    }

    public Node pop() {
        if (head.proximo == null) {
            Node ultimo = head;
            head = null;
            tamanho--;
            return ultimo;
        }

        Node atual = head;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        Node ultimo = atual.proximo;
        atual.proximo = null;
        tamanho--;
        return ultimo;
    }

    public void insert(int index, Node node) {
        if (index == 0) {
            node.proximo = head;
            head = node;
            tamanho++;
            return;
        }

        Node atual = head;
        for (int i = 0; i < index - 1; i++) {
            atual = atual.proximo;
        }

        node.proximo = atual.proximo;
        atual.proximo = node;
        tamanho++;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.proximo;
            tamanho--;
            return;
        }

        Node atual = head;
        for (int i = 0; i < index - 1; i++) {
            atual = atual.proximo;
        }

        atual.proximo = atual.proximo.proximo;
        tamanho--;
    }

    public Node elementAt(int index) {
        Node atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual;
    }

    public int size() {
        return tamanho;
    }

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

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        lista.push(new Node(10));
        lista.push(new Node(20));
        lista.push(new Node(30));
        lista.printList();

        lista.insert(1, new Node(99));
        lista.printList();

        lista.remove(1);
        lista.printList();

        Node node = lista.elementAt(2);
        System.out.println("Elemento no índice 2: " + node.valor);

        Node removido = lista.pop();
        System.out.println("Pop: " + removido.valor);
        lista.printList();

        System.out.println("Tamanho: " + lista.size());
    }
}

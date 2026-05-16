public class MapaDeHash {

    private static class Entry {
        int chave;
        int valor;

        Entry(int chave, int valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    private static final int TAMANHO = 10;
    private Entry[] tabela;

    public MapaDeHash() {
        tabela = new Entry[TAMANHO];
    }

    private int hash(int chave) {
        return Math.abs(chave % TAMANHO);
    }

    public void put(int chave, int valor) {
        int indice = hash(chave);

        for (int i = 0; i < TAMANHO; i++) {
            int posicao = (indice + i) % TAMANHO;

            if (tabela[posicao] == null) {
                tabela[posicao] = new Entry(chave, valor);
                return;
            }

            if (tabela[posicao].chave == chave) {
                tabela[posicao].valor = valor;
                return;
            }
        }
    }

    public int get(int chave) {
        int indice = hash(chave);

        for (int i = 0; i < TAMANHO; i++) {
            int posicao = (indice + i) % TAMANHO;

            if (tabela[posicao] == null) {
                break;
            }

            if (tabela[posicao].chave == chave) {
                return tabela[posicao].valor;
            }
        }

        return -1;
    }

    public void delete(int chave) {
        int indice = hash(chave);

        for (int i = 0; i < TAMANHO; i++) {
            int posicao = (indice + i) % TAMANHO;

            if (tabela[posicao] == null) {
                break;
            }

            if (tabela[posicao].chave == chave) {
                tabela[posicao] = null;
                return;
            }
        }
    }

    public void clear() {
        tabela = new Entry[TAMANHO];
    }

    public void printTabela() {
        for (int i = 0; i < TAMANHO; i++) {
            if (tabela[i] == null) {
                System.out.println("  [" + i + "] → vazio");
            } else {
                System.out.println("  [" + i + "] → chave: " + tabela[i].chave + ", valor: " + tabela[i].valor);
            }
        }
    }

    public static void main(String[] args) {
        MapaDeHash mapa = new MapaDeHash();

        mapa.put(3, 100);
        mapa.put(13, 200);
        mapa.put(7, 300);

        System.out.println("Estado da tabela:");
        mapa.printTabela();

        System.out.println("\nget(3):  " + mapa.get(3));
        System.out.println("get(13): " + mapa.get(13));
        System.out.println("get(7):  " + mapa.get(7));
        System.out.println("get(99): " + mapa.get(99));

        mapa.delete(3);
        System.out.println("\nApós delete(3):");
        System.out.println("get(3):  " + mapa.get(3));

        mapa.clear();
        System.out.println("\nApós clear():");
        mapa.printTabela();
    }
}

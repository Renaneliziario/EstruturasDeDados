// =============================================================
// EXERCÍCIO 5 — MAPA DE HASH (Hash Map)
// =============================================================
// Um Mapa de Hash armazena pares de chave/valor. Você informa
// uma chave e recupera o valor associado a ela rapidamente.
//
// Exemplo do dia a dia: uma agenda telefônica.
//   chave = nome da pessoa → valor = número de telefone
//
// COMO FUNCIONA NA MEMÓRIA:
// Usamos um array de tamanho fixo (10 posições).
// Para saber em qual posição guardar um par chave/valor,
// aplicamos uma FUNÇÃO HASH na chave — ela transforma a chave
// em um índice do array.
//
// FUNÇÃO HASH ESCOLHIDA: key % 10  (resto da divisão por 10)
// Motivo: simples, rápida e distribui bem as chaves entre as
// 10 posições disponíveis. Ex: chave 23 → 23 % 10 = índice 3.
//
// COLISÃO: quando duas chaves diferentes geram o mesmo índice.
// Ex: chave 3 e chave 13 → ambas resultam no índice 3.
// Solução usada aqui: SONDAGEM LINEAR — se a posição estiver
// ocupada, tentamos a próxima, e assim por diante.
//
// Visualização com put(3, 100) e put(13, 200):
//
//   índice: [ 0 ][ 1 ][ 2 ][ 3  ][ 4 ]...[ 3+1 ]
//   array:   null null null (3,100) null  (13,200)
//                           ↑ chave 3      ↑ colisão → foi para a próxima posição
// =============================================================

public class MapaDeHash {

    // -------------------------------------------------------------
    // CLASSE INTERNA: Entry
    // Representa um par chave/valor armazenado no mapa.
    // -------------------------------------------------------------
    private static class Entry {
        int chave;
        int valor;

        Entry(int chave, int valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    // O array tem tamanho fixo de 10, conforme o enunciado.
    // Posições vazias ficam como null.
    private static final int TAMANHO = 10;
    private Entry[] tabela;

    // Construtor: cria o array com 10 posições, todas vazias (null)
    public MapaDeHash() {
        tabela = new Entry[TAMANHO];
    }

    // -------------------------------------------------------------
    // FUNÇÃO HASH: transforma a chave em um índice do array.
    // Usamos o resto da divisão pelo tamanho da tabela.
    // Isso garante que o índice sempre estará entre 0 e 9.
    // -------------------------------------------------------------
    private int hash(int chave) {
        return Math.abs(chave % TAMANHO);
        // Math.abs garante que chaves negativas não gerem índice negativo
    }

    // -------------------------------------------------------------
    // put(chave, valor): adiciona ou atualiza um par no mapa.
    //
    // 1. Calcula o índice com a função hash.
    // 2. Se a posição estiver livre, insere ali.
    // 3. Se a posição já tiver a mesma chave, atualiza o valor.
    // 4. Se tiver outra chave (colisão), tenta a próxima posição
    //    (sondagem linear) até achar uma posição livre.
    // -------------------------------------------------------------
    public void put(int chave, int valor) {
        int indice = hash(chave);

        // percorre o array a partir do índice calculado
        for (int i = 0; i < TAMANHO; i++) {
            // usamos % TAMANHO para voltar ao início se chegar no fim do array
            int posicao = (indice + i) % TAMANHO;

            if (tabela[posicao] == null) {
                // posição livre: insere aqui
                tabela[posicao] = new Entry(chave, valor);
                return;
            }

            if (tabela[posicao].chave == chave) {
                // chave já existe: apenas atualiza o valor
                tabela[posicao].valor = valor;
                return;
            }
            // posição ocupada por outra chave → tenta a próxima (colisão)
        }
    }

    // -------------------------------------------------------------
    // get(chave): retorna o valor associado à chave informada.
    //
    // 1. Calcula o índice com a função hash.
    // 2. Percorre a partir dali até encontrar a chave ou um null.
    //    (null significa que a chave não existe no mapa)
    // -------------------------------------------------------------
    public int get(int chave) {
        int indice = hash(chave);

        for (int i = 0; i < TAMANHO; i++) {
            int posicao = (indice + i) % TAMANHO;

            if (tabela[posicao] == null) {
                // chegou numa posição vazia: chave não existe
                break;
            }

            if (tabela[posicao].chave == chave) {
                return tabela[posicao].valor; // chave encontrada!
            }
        }

        // convenção: retorna -1 quando a chave não é encontrada
        return -1;
    }

    // -------------------------------------------------------------
    // delete(chave): remove o par associado à chave informada.
    //
    // Percorre a partir do índice hash até encontrar a chave.
    // Quando encontrar, remove (define a posição como null).
    // -------------------------------------------------------------
    public void delete(int chave) {
        int indice = hash(chave);

        for (int i = 0; i < TAMANHO; i++) {
            int posicao = (indice + i) % TAMANHO;

            if (tabela[posicao] == null) {
                // chegou numa posição vazia: chave não existe
                break;
            }

            if (tabela[posicao].chave == chave) {
                tabela[posicao] = null; // remove o par
                return;
            }
        }
    }

    // -------------------------------------------------------------
    // clear(): remove todos os elementos do mapa.
    // Recria o array zerado, descartando todos os pares.
    // -------------------------------------------------------------
    public void clear() {
        tabela = new Entry[TAMANHO];
    }

    // -------------------------------------------------------------
    // Método auxiliar para visualizar o estado interno da tabela.
    // Útil para entender onde cada par foi armazenado.
    // -------------------------------------------------------------
    public void printTabela() {
        for (int i = 0; i < TAMANHO; i++) {
            if (tabela[i] == null) {
                System.out.println("  [" + i + "] → vazio");
            } else {
                System.out.println("  [" + i + "] → chave: " + tabela[i].chave + ", valor: " + tabela[i].valor);
            }
        }
    }

    // -------------------------------------------------------------
    // Método main para testar
    // -------------------------------------------------------------
    public static void main(String[] args) {
        MapaDeHash mapa = new MapaDeHash();

        mapa.put(3, 100);  // índice: 3 % 10 = 3
        mapa.put(13, 200); // índice: 13 % 10 = 3 → colisão! vai para posição 4
        mapa.put(7, 300);  // índice: 7 % 10 = 7

        System.out.println("Estado da tabela:");
        mapa.printTabela();

        System.out.println("\nget(3):  " + mapa.get(3));  // 100
        System.out.println("get(13): " + mapa.get(13)); // 200
        System.out.println("get(7):  " + mapa.get(7));  // 300
        System.out.println("get(99): " + mapa.get(99)); // -1 (não existe)

        mapa.delete(3);
        System.out.println("\nApós delete(3):");
        System.out.println("get(3):  " + mapa.get(3));  // -1 (removido)

        mapa.clear();
        System.out.println("\nApós clear():");
        mapa.printTabela();
    }
}

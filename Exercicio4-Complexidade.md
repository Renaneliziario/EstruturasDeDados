# Exercício 4 — Complexidade Assintótica

A complexidade assintótica mede como o tempo de execução ou o uso de memória de um algoritmo cresce conforme a entrada aumenta.

**Notações mais comuns:**
- `O(1)` → tempo constante: não importa o tamanho, sempre igual.
- `O(n)` → tempo linear: cresce proporcionalmente ao tamanho.

---

## Pilha (`Pilha.java` — implementação com array)

**`push(valor)`**
- Complexidade de **tempo:** `O(1)`
- Motivo: apenas incrementa `topo` e coloca o valor no array. Não importa quantos elementos já existem — é sempre rápido.

**`pop()`**
- Complexidade de **tempo:** `O(1)`
- Motivo: apenas lê o valor do topo e decrementa `topo`. Não percorre nenhum elemento.

**Complexidade de espaço:** `O(n)`
Motivo: o array cresce conforme mais elementos são adicionados. Para n elementos, usamos n posições de memória.

---

## Fila (`Fila.java` — implementação com array)

**`enqueue(valor)`**
- Complexidade de **tempo:** `O(1)`
- Motivo: coloca o valor na posição `fim` e incrementa `fim`. Operação direta, sem percorrer nada.

**`dequeue()`**
- Complexidade de **tempo:** `O(1)`
- Motivo: lê o valor na posição `frente` e incrementa `frente`. Operação direta, sem percorrer nada.

**`front()`**
- Complexidade de **tempo:** `O(1)`
- Motivo: acessa diretamente o índice `frente` no array.

**`rear()`**
- Complexidade de **tempo:** `O(1)`
- Motivo: acessa diretamente o índice `fim - 1` no array.

**Complexidade de espaço:** `O(n)`
Motivo: mesmo raciocínio da Pilha — n elementos, n posições.

---

## Lista Encadeada (`ListaEncadeada.java` — implementação com nodes)

**`push(node)`**
- Complexidade de **tempo:** `O(n)`
- Motivo: para adicionar ao fim, percorre todos os nodes da lista até encontrar o último. Quanto maior a lista, mais tempo leva.

**`pop()`**
- Complexidade de **tempo:** `O(n)`
- Motivo: para remover o último, precisa chegar até o penúltimo node — o que exige percorrer a lista toda.

**`insert(index, node)`**
- Complexidade de **tempo:** `O(n)`
- Motivo: percorre a lista até a posição indicada. No pior caso (último índice), percorre todos os elementos.

**`remove(index)`**
- Complexidade de **tempo:** `O(n)`
- Motivo: mesmo raciocínio do `insert` — precisa caminhar até a posição desejada.

**`elementAt(index)`**
- Complexidade de **tempo:** `O(n)`
- Motivo: não há acesso direto por índice como no array. É necessário caminhar desde o início até a posição.

**Complexidade de espaço:** `O(n)`
Motivo: cada elemento ocupa um node na memória. Para n elementos, temos n nodes alocados.

---

## Resumo Geral

| Estrutura        | Método      | Tempo  | Espaço |
|------------------|-------------|--------|--------|
| Pilha            | `push`      | `O(1)` | `O(n)` |
| Pilha            | `pop`       | `O(1)` |        |
| Fila             | `enqueue`   | `O(1)` | `O(n)` |
| Fila             | `dequeue`   | `O(1)` |        |
| Fila             | `front`     | `O(1)` |        |
| Fila             | `rear`      | `O(1)` |        |
| Lista Encadeada  | `push`      | `O(n)` | `O(n)` |
| Lista Encadeada  | `pop`       | `O(n)` |        |
| Lista Encadeada  | `insert`    | `O(n)` |        |
| Lista Encadeada  | `remove`    | `O(n)` |        |
| Lista Encadeada  | `elementAt` | `O(n)` |        |

Pilha e Fila são mais eficientes em tempo porque usam array e acessam posições diretamente pelo índice. A Lista Encadeada é `O(n)` na maioria das operações porque precisa caminhar pelos nodes para chegar à posição desejada.

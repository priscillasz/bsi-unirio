package questao04;

public class Heap {
    int[] harr; // Array de elementos que estão no heap
    int tam; // Qtd de elementos no heap
    int capacidade; // Capacidade max do heap

    // construtor -> cria uma heap a partir de um vetor de um tamanho específico
    public Heap(int[] a, int tamanho) {
        tam = tamanho;
        capacidade = tamanho;
        harr = a;
        int i = (tam - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    // método recursivo para transformar uma subárvore em heap (?)
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int menor = i;
        if (l < tam && harr[l] < harr[i])
            menor = l;
        if (r < tam && harr[r] < harr[menor])
            menor = r;
        if (menor != i) {
            swap(i, menor);
            MinHeapify(menor);
        }
    }

    int parent(int i) { return (i - 1) / 2; }

    // get index do filho esquerdo do nó que está no index i
    int left(int i) { return (2 * i + 1); }

    // get index do filho direito do nó que está no index i
    int right(int i) { return (2 * i + 2); }

    // remove o menor elemento, ou seja, a raíz da heap
    int extraiMin() {
        if (tam <= 0)
            return Integer.MAX_VALUE;
        if (tam == 1) {
            tam--;
            return harr[0];
        }

        // Armazena o menor valor e remove do heap
        int root = harr[0];
        harr[0] = harr[tam - 1];
        tam--;
        MinHeapify(0);

        return root;
    }

    // Método para inserir uma nova chave
    void insereChave(int k) {
        if (tam == capacidade) {
            System.out.println(
                    "Overflow: Não foi possível inserir a chave");
            return;
        }

        // Insere a nova chave ao final
        tam++;
        int i = tam - 1;
        harr[i] = k;

        // Corrige o min heap se precisar
        while (i != 0 && harr[parent(i)] > harr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // checa se o tamanho do heap = 1
    boolean ehTam1() { return (tam == 1); }

    // método para inverter dois elementos
    void swap(int x, int y) {
        int temp = harr[x];
        harr[x] = harr[y];
        harr[y] = temp;
    }

    // método que retorna o custo mínimo para conectar n cabos de tamanhos diferentes
    static int custoMinimo(int[] len, int n) {
        int custo = 0;
        
        // Criação de um heap de capacidade = n para armazenar os cabos
        Heap minHeap = new Heap(len, n);
        
        // Iterar enquanto o tamanho da heap seja diferente de 1
        while (!minHeap.ehTam1()) {
            // Extrair dois menores cabos do heap
            int min = minHeap.extraiMin();
            int sec_min = minHeap.extraiMin();

            custo += (min + sec_min); // Atualiza o custo total
            
            // Add um novo cabo no heap com tamanho igual a soma dos dois cabos retirados
            minHeap.insereChave(min + sec_min);
        }

       // retorna o custo total
        return custo;
    }
}
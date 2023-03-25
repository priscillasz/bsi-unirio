package questao08;

import java.util.*;

/* A Daenerys é farmacêutica e recebe dez caixas de remédios nos lotes 35, 33, 42, 10, 14, 19, 27, 44, 26, 31 impressos neles.
Ela sempre arruma as caixas manualmente e fica frustrada toda vez. Ela pensou que teria muitos problemas no futuro para
 organizar as caixas se o número de caixas de remédios fosse grande. Ela precisa automatizar esse processo. Como você é
 um bom programador, a Daenerys solicitou sua ajuda. Escreva um algoritmo de ordenação rápido ótimo para organizar os
 caixas em ordem crescente de números de lote e mostrar cada etapa do algoritmo em detalhes usando a sequência acima de
  números de lote. */

public class Q8 {

    public static void imprime(int[] vet){
        System.out.print("|");

        for(int i = 0; i < vet.length; i++){
            System.out.print(vet[i] + "|");
        }
        System.out.print("\n");
    }

    //Heapify (verifica se o nó corrente é maior que os seus filhos, se não for, ajusta)
    public static void heapify(int[] vet, int tam, int i) {
        imprime(vet); //IMPRESSÃO MAIS COMPLETA, MOSTRANDO TODOS OS PASSOS!
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;
        int maior = i;

        //verificando se o vetor tem ou não prioridade heap.
        if (esq < tam && vet[esq] > vet[maior]) {
            maior = esq;
        }
        if (dir < tam && vet[dir] > vet[maior]) {
            maior = dir;
        }
        if (maior != i) {
            int tmp = vet[i];
            vet[i] = vet[maior];
            vet[maior] = tmp;

            //UMA IMPRESSÃO AQUI MOSTRA TAMBÉM ALTERAÇÕES, MAS RESUMIDAS...
            //imprime(vet);

            heapify(vet, tam, maior);
        }
    }


    public static void heapSort(int[] vetor) {
        if (vetor.length == 0) {
            return;
        }

        int tam = vetor.length;

        // Construindo uma heap Máxima
        System.out.println("Transformando o Array em Heap Máxima:");
        for (int i = tam / 2 - 1; i >= 0; i--) {
            heapify(vetor, tam, i);
        }
        System.out.print("\n");

        /* Aplicando o heapsort
        (Resumidamente, a cada iteração, remove-se o maior nó,
        que é substituido pelo menor nó, e chama-se o método heapify
        pra "reconstruir" a Heap novamente) */

        System.out.println("Aplicando o algoritmo Heapsort:");
        for (int i = tam - 1; i >= 0; i--) {
            int tmp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = tmp;
            heapify(vetor, i, 0);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] array = {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};
        heapSort(array);

        System.out.println("Heapsort - Array ordenado:");
        imprime(array);
    }
}


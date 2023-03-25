package questao04;

/* Um operador possui n cabos de tamanhos diferentes e precisa realizar uma conexão para seu cliente.
Ele quer conectar esses cabos em um só. Considere que o custo de conectar dois cabos é igual a soma de seus comprimentos.
Escreva um algoritmo utilizando fila de prioridade para juntar esses cabos sempre com o menor custo possível. */

import static questao04.Heap.custoMinimo;

public class Q4 {
    public static void main(String[] args) {
        int[] cabos = { 10, 8, 2, 3, 5 };
        int tamanho = cabos.length;

        System.out.println("O menor custo para conectar os cabos é: " + custoMinimo(cabos, tamanho));
    }
}

package questao06;
import java.util.LinkedList;

/* Considere uma linked list com n nós onde n é desconhecido.
Escreva um algoritmo capaz de encontrar o nó do meio [n/2] dessa lista em uma única passagem. */

public class Q6 {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();

        int n = 9;
        int meio = (n/2) - 1;

        // Se n é impar
        if (n % 2 != 0)
            meio++;

        // adiciona elementos ate o tamanho n
        for (int i = 0 ; i < n ; i++)
            lista.add(i);

        // imprime a lista
    System.out.println("Lista: " + lista);

        /*System.out.printf("A lista tem %d nós",n);
        System.out.println("\nOs elementos da lista são:"+lista);*/

        // Percorre a lista uma vez ate o meio
        for (int i = 0 ; i <=meio ; i++)
            if (i == meio)
                System.out.printf("O valor do nó do meio é %d, que fica na posição %d da lista ",i,i+1);
    }
}
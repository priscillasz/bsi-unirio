package questao02;

/* Imagine que sete carros estão parados em um estacionamento. Um número é dado ao dono de cada carro estacionado
e esse mesmo número é colocado no veículo. A sequência de veículos estacionados é a seguinte: 1, 2, 3, 4, 5, 6, 7.
Considere que o manobrista reverteu uma parte da sequência e acabou com a seguinte ordem: 1, 5, 4, 3, 2, 6, 7.
Escreva um algoritmo para encontrar a ordem original dos carros. Use Linked List. */

public class Q2 {
    public static void main(String[] args) {
        LinkedList<Integer> sequencia = new LinkedList<Integer>();

        sequencia.push(sequencia,1);
        sequencia.push(sequencia,5);
        sequencia.push(sequencia,4);
        sequencia.push(sequencia,3);
        sequencia.push(sequencia,2);
        sequencia.push(sequencia,6);
        sequencia.push(sequencia,7);

        System.out.println("Lista inicial: ");
        sequencia.printList(sequencia.head);

        sequencia.head = sequencia.mergeSort(sequencia.head);

        System.out.println("\nLista final: ");
        sequencia.printList(sequencia.head);
    }
}

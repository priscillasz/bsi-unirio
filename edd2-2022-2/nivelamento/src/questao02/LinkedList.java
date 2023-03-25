package questao02;

public class LinkedList<Integer> {

    Node head = null;

    static class Node {
        int valor;
        Node next;

        public Node(int valor)
        {
            this.valor = valor;
        }
    }

    Node sortedMerge(Node a, Node b)
    {
        Node resultado = null;

        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.valor <= b.valor) {
            resultado = a;
            resultado.next = sortedMerge(a.next, b);
        }
        else {
            resultado = b;
            resultado.next = sortedMerge(a, b.next);
        }
        return resultado;
    }

    Node mergeSort(Node h) {
        if (h == null || h.next == null) {
            return h;
        }

        Node meio = pegaMeio(h);
        Node meioProximo = meio.next;

        meio.next = null;

        Node esquerda = mergeSort(h);

        Node direita = mergeSort(meioProximo);

        Node listaArrumada = sortedMerge(esquerda, direita);
        return listaArrumada;
    }

    public static Node pegaMeio (Node head) {

        if (head == null)
            return head;

        Node lento = head, rapido = head;

        while (rapido.next != null && rapido.next.next != null) {

            lento = lento.next;
            rapido = rapido.next.next;
        }

        return lento;

    }

    LinkedList<Integer> push(LinkedList<Integer> sequencia,int novoValor) {
        Node novo_node = new Node(novoValor);

        if (sequencia.head == null) {
            sequencia.head = novo_node;
        }
        else {
            Node last = sequencia.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = novo_node;
        }


        return sequencia;
    }

    void printList(Node headref)
    {
        while (headref != null) {
            System.out.print(headref.valor + " ");
            headref = headref.next;
        }
    }
}

package questao01;

public class Java {

    //Busca a posição de um elemento na Array - O(n)
    public static int buscaPosicao(int[] vetor, int valor) { 

        for (int i = 0; i < vetor.length; i++) { // O(n)
            if(vetor[i] == valor)
                return i;
        }
        
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] vetor = {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};
        int numero = 2;
        int busca = buscaPosicao(vetor, numero);

        if(busca != Integer.MIN_VALUE)
            System.out.println("O numero " + numero + " esta no vetor.");
        else
            System.out.println("O numero " + numero + " nao esta no vetor.");
    }
}